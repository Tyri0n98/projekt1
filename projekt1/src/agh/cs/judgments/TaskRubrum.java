package agh.cs.judgments;

import java.util.HashMap;

public class TaskRubrum {

    public void execute(HashMap<String, Judgment> judgments, String caseNumber){
        Judgment judgment;
        if(judgments.containsKey(caseNumber))
            judgment = judgments.get(caseNumber);
        else {
            System.out.println("Nie istnieje orzeczenie o sygnaturze: " + caseNumber);
            return;
        }
        System.out.println("Sygnatura orzeczenia:                 " + judgment.getCaseNumber());
        System.out.println("Data wydania orzeczenia:              " + judgment.getDate());
        System.out.println("Rodzaj sądu:                          " + judgment.getCourtType());
        System.out.print("Sędziowie:                            ");
        boolean first = true;
        for(Judge judge: judgment.getJudges()){
            if(first) {
                System.out.print(judge.getName() + "  ");
                first = false;
            }
            else
                System.out.print("                                      " + judge.getName() + "  ");
            for(JudgeRole role: judge.getSpecialRoles()){
                System.out.print(role);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
