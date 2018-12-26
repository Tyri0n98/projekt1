package agh.cs.judgments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskCourts {
    private HashMap<String, Judgment> judgments;
    private LinkedHashMap<CourtType, Integer> courtTypes;

    public TaskCourts(HashMap<String, Judgment> judgments){
        this.judgments = judgments;
        this.courtTypes = new LinkedHashMap<>();
    }

    public String execute(){
        for(Judgment judgment: judgments.values()){
            if(courtTypes.containsKey(judgment.getCourtType()))
                courtTypes.replace(judgment.getCourtType(), courtTypes.get(judgment.getCourtType()), courtTypes.get(judgment.getCourtType()) + 1);
            else
                courtTypes.put(judgment.getCourtType(), 1);
        }
        String result = "";
        for(Map.Entry<CourtType, Integer> entry: courtTypes.entrySet()){
            result += entry.getKey() + ": " + entry.getValue().toString() + "\n";
        }
        return result;
    }
}
