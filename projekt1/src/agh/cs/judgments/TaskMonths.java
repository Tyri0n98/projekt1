package agh.cs.judgments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskMonths {
    private HashMap<String, Judgment> judgments;
    private HashMap<Month, Integer> months;

    public TaskMonths(HashMap<String, Judgment> judgments){
        this.judgments = judgments;
        this.months = new LinkedHashMap<>();
        Integer mon = 1;
        for(int i = 1; i<=12; i++){
            if(mon<10)
                months.put(ToEnum.toMonth("0" + mon.toString()), 0);
            else
                months.put(ToEnum.toMonth(mon.toString()), 0);
            mon++;
        }
    }

    public String execute(){
        for(Judgment judgment: judgments.values()){
            months.replace(ToEnum.toMonth(judgment.getDate().getMonth()), months.get(ToEnum.toMonth(judgment.getDate().getMonth())),months.get(ToEnum.toMonth(judgment.getDate().getMonth()))+1 );
        }
        String result ="";
        for(Map.Entry<Month, Integer> entry: months.entrySet()){
            result += entry.getKey().toString() + ": " + entry.getValue() + "\n";
        }
        return result;
    }
}
