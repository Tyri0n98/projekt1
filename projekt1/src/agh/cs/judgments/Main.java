package agh.cs.judgments;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args){
        //JSONParser parser = new JSONParser();
        try {
            Path dir = Paths.get("/home/tyri0n/projekt/jsons/");
            Parser parser = new Parser();
            parser.parseDir(dir);
            TaskRubrum rubrum = new TaskRubrum();
            rubrum.execute(parser, "III AUa 846/12");
            /*Object obj = parser.parse(new FileReader("/home/tyri0n/projekt/jsons/judgments-348.json"));
            JSONObject json = (JSONObject) obj;
            JSONArray items = (JSONArray) json.get("items");
            for(Object object: items){
                JSONObject jsonObject = (JSONObject) object;
                System.out.println(jsonObject.get("judgmentType"));
            }*/
        }catch(ParseException | IOException e){
            e.printStackTrace();
        }
    }
}
