package agh.cs.judgments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskRegulations {
    private HashMap<String, Judgment> judgments;
    private HashMap<String, Integer> regulations;
    private LinkedHashMap<String, Integer> topRegulations;

    public TaskRegulations(HashMap<String, Judgment> judgments){
        this.judgments = judgments;
        this.regulations = new HashMap<>();
        this.topRegulations = new LinkedHashMap<>();
    }

    public String execute(){
        for(Judgment judgment: judgments.values()){
            for(Regulation regulation: judgment.getReferencedRegulations()){
                if(regulations.containsKey(regulation.getJournalTitle()))
                    regulations.replace(regulation.getJournalTitle(), regulations.get(regulation.getJournalTitle()), regulations.get(regulation.getJournalTitle()) + 1);
                else
                    regulations.put(regulation.getJournalTitle(), 1);

            }
        }
        for(int i =0; i<10; i++){
            int max=0;
            String maxS="";
            for(Map.Entry<String, Integer> entry: regulations.entrySet()){
                if(entry.getValue()>max && !topRegulations.containsKey(entry.getKey())){
                    max = entry.getValue();
                    maxS = entry.getKey();
                }
            }
            topRegulations.put(maxS, max);
        }
        String result = "";
        for(Map.Entry<String, Integer> entry: topRegulations.entrySet()){
            result += entry.getKey() + "  " + entry.getValue() + "\n";
        }
        return result;
    }
}
