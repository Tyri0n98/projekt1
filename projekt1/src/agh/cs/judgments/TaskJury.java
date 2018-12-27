package agh.cs.judgments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskJury {
    private HashMap<String, Judgment> judgments;
    private HashMap<Integer, Integer> judgesQuantity;
    private LinkedHashMap<Integer, Integer> sortedJudgesQuantity;

    public TaskJury(HashMap<String, Judgment> judgments){
        this.judgments = judgments;
        this.judgesQuantity = new HashMap<>();
        this.sortedJudgesQuantity = new LinkedHashMap<>();
    }

    public String execute(){
        for(Judgment judgment: judgments.values()){
            int judgesNo = judgment.getJudges().size();
            if(judgesQuantity.containsKey(judgesNo))
                judgesQuantity.replace(judgesNo, judgesQuantity.get(judgesNo), judgesQuantity.get(judgesNo) + 1);
            else
                judgesQuantity.put(judgesNo, 1);
        }
        for(int i =0; i<judgesQuantity.size(); i++ ){
            int min = Integer.MAX_VALUE;
            for(Integer key: judgesQuantity.keySet()) {
                if (key < min && !sortedJudgesQuantity.containsKey(key))
                    min = key;
            }
            sortedJudgesQuantity.put(min, judgesQuantity.get(min));
        }
        String result ="";
        for(Map.Entry<Integer, Integer> entry: sortedJudgesQuantity.entrySet()){
            result += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return result;
    }
}
