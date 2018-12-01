package agh.cs.judgments;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("/home/tyri0n/projekt/jsons/judgments-348.json"));
            JSONObject json = (JSONObject) obj;
            JSONArray items = (JSONArray) json.get("items");
            for(Object object: items){
                JSONObject jsonObject = (JSONObject) object;
                System.out.println(jsonObject.get("judgmentType"));
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(ParseException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
