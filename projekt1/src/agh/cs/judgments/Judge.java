package agh.cs.judgments;

import java.util.LinkedList;

public class Judge {
    private String name;
    //private String function;
    private LinkedList<JudgeRole> specialRoles;

    public Judge(String name, /*String function,*/ LinkedList<JudgeRole> specialRoles){
        this.name = name;
        //this.function = function;
        this.specialRoles = specialRoles;
    }

    public boolean equals(Judge judge){
        return this.name.equals(judge.name);
    }

    public String getName() {
        return name;
    }

    public LinkedList<JudgeRole> getSpecialRoles() {
        return specialRoles;
    }
}
