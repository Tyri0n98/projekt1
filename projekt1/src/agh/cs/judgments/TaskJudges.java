package agh.cs.judgments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskJudges {
    private HashMap<String, Judgment> judgments;
    private LinkedHashMap<String, Integer> judges;
    private LinkedHashMap<String, Integer> topJudges;

    public TaskJudges(HashMap<String, Judgment> judgments){
        this.judgments=judgments;
        this.judges = new LinkedHashMap<>();
        this.topJudges = new LinkedHashMap<>();
    }

    public String execute(){
        for(Judgment judgment: judgments.values()){
            for(Judge judge: judgment.getJudges()){
                if(judges.containsKey(judge.getName()))
                    judges.replace(judge.getName(), judges.get(judge.getName()), judges.get(judge.getName())+1);
                else
                    judges.put(judge.getName(), 1);
            }
        }
        for(int i =0; i<10; i++){
            Integer max =0;
            String maxS="";
            for(Map.Entry<String, Integer> entry: judges.entrySet()){
                if(entry.getValue()>max && !topJudges.containsKey(entry.getKey())){
                    max = entry.getValue();
                    maxS = entry.getKey();
                }
            }
            topJudges.put(maxS, max);
        }
        String result = "";
        for(Map.Entry<String, Integer> entry: topJudges.entrySet()){
            result += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return result;
    }
}
