package agh.cs.judgments;

import java.util.HashMap;

public class Solver {
    private HashMap<String, Judgment> judgments;

    public Solver(HashMap<String, Judgment> judgments){
        this.judgments = judgments;
    }

    public void solve(Task task){
        TaskName taskName = task.getTaskName();
        switch (taskName){
            case RUBRUM:{
                for(String arg: task.getArgs()) {
                TaskRubrum taskRubrum = new TaskRubrum();
                taskRubrum.execute(judgments, arg);
                }
                if (task.getArgs().isEmpty()) System.out.println("Nie podano argumentów");
            }
            default: return;
        }
    }

}
