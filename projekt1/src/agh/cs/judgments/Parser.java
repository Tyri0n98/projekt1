package agh.cs.judgments;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;

public class Parser {
    private HashMap<String, Judgment> judgments;

    public HashMap<String, Judgment> getJudgments(){
        return judgments;
    }

    public Parser(){
        this.judgments = new HashMap<>();
    }

    public void parseDir(Path dir) throws IOException, ParseException {
        DirectoryStream<Path> stream= Files.newDirectoryStream(dir,"*.{json}");
        for(Path file: stream){
            parseFile(file);
        }
    }

    private void parseFile(Path pathToFile) throws IOException, ParseException {
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

            this.judgments.put(caseNumber, new Judgment(item.get("id").toString(), caseNumber, ToEnum.toCourtType(item.get("courtType").toString()), judges, referencedRegulations, new Date(item.get("judgmentDate").toString())));
        }
    }
}
