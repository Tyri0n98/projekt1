package agh.cs.judgments;

import java.util.HashMap;
import java.util.LinkedList;

public class TaskJudge {
    private int quantity;
    private Judge judge;
    private HashMap<String, Judgment> judgments;

    public TaskJudge(String name, HashMap<String, Judgment> judgments){
        this.quantity=0;
        this.judge = new Judge(name, new LinkedList<JudgeRole>());
        this.judgments = judgments;
    }

    public String execute(){
        for(Judgment judgment: judgments.values()){
            for(Judge judge: judgment.getJudges()){
                if(this.judge.equals(judge)) this.quantity++;
            }
        }
        return this.judge.getName() + ": "+ this.quantity + " orzeczeń" + "\n";
    }
}
