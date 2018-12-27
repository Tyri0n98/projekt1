package agh.cs.judgments;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Parser {
    private HashMap<String, Judgment> judgments;

    public HashMap<String, Judgment> getJudgments(){
        return judgments;
    }

    public Parser(){
        this.judgments = new HashMap<>();
    }

    public void parseDir(Path dir) throws IOException, ParseException {
        DirectoryStream<Path> jsonStream= Files.newDirectoryStream(dir,"*.{json}");
        for(Path file: jsonStream){
            parseJSONFile(file);
        }
        DirectoryStream<Path> htmlStream = Files.newDirectoryStream(dir, "*.{html}");
        for(Path file: htmlStream){
            parseHTMLFile(file);
        }
    }

    private void parseJSONFile(Path pathToFile) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonFile = (JSONObject) jsonParser.parse(new FileReader(pathToFile.toString()));
        JSONArray items = (JSONArray) jsonFile.get("items");
        for(Object object: items){
            JSONObject item = (JSONObject) object;

            JSONArray courtCases = (JSONArray) item.get("courtCases");
            JSONObject courtCase = (JSONObject) courtCases.get(0);
            String caseNumber = courtCase.get("caseNumber").toString();

            LinkedList<Judge> judges = new LinkedList<>();
            JSONArray jsonJudges = (JSONArray) item.get("judges");
            for(Object objJudge: jsonJudges){
                JSONObject judge = (JSONObject) objJudge;
                LinkedList<JudgeRole> specialRoles = new LinkedList<>();
                JSONArray jsonSpecialRoles = (JSONArray) judge.get("specialRoles");
                for(Object objRole: jsonSpecialRoles){
                    specialRoles.add(ToEnum.toJudgeRole(objRole.toString()));
                }
                judges.add(new Judge(judge.get("name").toString(), specialRoles));
            }

            LinkedList<Regulation> referencedRegulations = new LinkedList<>();
            JSONArray jsonRegulations = (JSONArray) item.get("referencedRegulations");
            for(Object objRegulation: jsonRegulations){
                JSONObject regulation = (JSONObject) objRegulation;
                referencedRegulations.add(new Regulation(regulation.get("journalTitle").toString(), regulation.get("journalNo").toString(), regulation.get("journalYear").toString(), regulation.get("journalEntry").toString(), regulation.get("text").toString()));
            }

            this.judgments.put(caseNumber, new Judgment(caseNumber, item.get("textContent").toString(),ToEnum.toCourtType(item.get("courtType").toString()), judges, referencedRegulations, new Date(item.get("judgmentDate").toString())));
        }
    }
    private void parseHTMLFile(Path pathToFile) throws IOException{
        File file = new File(pathToFile.toString());
        Document doc = Jsoup.parse(file, "UTF-8", "http://example.com/");
        Element elem = doc.getElementById("warunek");
        Elements elements;
        String caseNumber = elem.text();
        int index = caseNumber.indexOf('-');
        caseNumber = caseNumber.substring(0, index -1);
        String date= "";
        CourtType courtType = CourtType.UNSPECIFIED;
        LinkedList<Judge> judges = new LinkedList<>();
        LinkedList<Regulation> referencedRegulations = new LinkedList<>();
        String textContent = "";
        elements = doc.select("tr.niezaznaczona");
        for(Element el: elements){
            Element label = el.selectFirst("td.info-list-label");
            Element value = el.selectFirst("td.info-list-value");
            if(label != null && value !=null) {
                if (label.text().equals("Data orzeczenia")) {
                    date = value.text();
                    date = date.substring(0, 10);
                }
                if(label.text().equals("Sąd")){
                    courtType = ToEnum.toCourtType(value.text());
                }
                if(label.text().equals("Sędziowie")){
                    List judges1 = value.textNodes();
                    for(Object objJudge: judges1){
                        String judge = ((TextNode) objJudge).toString();
                        if(judge.charAt(0) == ' ') judge = judge.substring(1);
                        String name;
                        String roles;
                        LinkedList<JudgeRole> specialRoles = new LinkedList<>();
                        if(judge.contains("/")){
                            name = judge.substring(0, judge.indexOf('/') - 1);
                            roles = judge.substring(judge.indexOf('/')+1);
                            roles = roles.substring(0, roles.indexOf('/'));
                            for(int i = 0; i<roles.length(); i++){
                                if(roles.charAt(i) == ' '){
                                    specialRoles.add(ToEnum.toJudgeRole(roles.substring(0,i)));
                                    roles = roles.substring(i+1);
                                }
                            }
                        }else {
                            name = judge;
                        }
                        judges.add(new Judge(name, specialRoles));
                    }
                }
                if(label.text().equals("Powołane przepisy")){
                    Elements regulations = value.select("span.nakt");
                    for(Element regulation: regulations){
                        referencedRegulations.add(new Regulation(regulation.text()));
                    }
                }
            }
            Element justification = el.selectFirst("td.info-list-label-uzasadnienie");
            if(justification != null && justification.selectFirst("div.lista-label").text().equals("Uzasadnienie")){
                textContent = justification.selectFirst("span.info-list-value-uzasadnienie").text();
            }

        }
        this.judgments.put(caseNumber, new Judgment(caseNumber, textContent, courtType, judges, referencedRegulations, new Date(date)));
    }
}
