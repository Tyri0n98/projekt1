package agh.cs.judgments;

import java.util.LinkedList;

public class Task {
    private String input;
    private TaskName taskName;
    private LinkedList<String> args = new LinkedList<>();

    public Task(String input){
        this.input=input;
        setTask();
    }

    private void setTask(){
        int i;
        for(i=0; i < this.input.length(); i++){
            if(this.input.charAt(i)==' ') break;
        }
        this.taskName = ToEnum.toTask(this.input.substring(0,i));

        int quotationQuantity = 0;
        int start =0;
        for(int j=i; j<this.input.length(); j++){
            if(this.input.charAt(j)=='"' && quotationQuantity % 2 == 0){
                start = j;
                quotationQuantity++;
            }else if(this.input.charAt(j)=='"' && quotationQuantity % 2 == 1){
                args.add(this.input.substring(start+1, j));
                quotationQuantity++;
            }
        }
    }

    public TaskName getTaskName() {
        return taskName;
    }

    public LinkedList<String> getArgs() {
        return args;
    }
}
