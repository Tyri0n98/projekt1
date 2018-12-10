package agh.cs.judgments;

import java.util.LinkedList;
import java.util.List;

public class Judge {
    private String name;
    //private String function;
    private LinkedList<JudgeRole> specialRoles;

    public Judge(String name, /*String function,*/ LinkedList<JudgeRole> specialRoles){
        this.name = name;
        //this.function = function;
        this.specialRoles = specialRoles;
    }
}
