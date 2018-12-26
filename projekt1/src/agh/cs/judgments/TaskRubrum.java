package agh.cs.judgments;

import java.util.HashMap;

public class TaskRubrum {

    public String execute(HashMap<String, Judgment> judgments, String caseNumber){
        String result ="";
        Judgment judgment;
        if(judgments.containsKey(caseNumber))
            judgment = judgments.get(caseNumber);
        else
            return "Nie istnieje orzeczenie o sygnaturze: " + caseNumber;

        result += "Sygnatura orzeczenia:                 " + judgment.getCaseNumber() + "\n";
        result += "Data wydania orzeczenia:              " + judgment.getDate() + "\n";
        result += "Rodzaj sądu:                          " + judgment.getCourtType() + "\n";
        result += "Sędziowie:                            ";
        boolean first = true;
        for(Judge judge: judgment.getJudges()){
            if(first) {
                result += judge.getName() + "  ";
                first = false;
            }
            else
                result += "                                      " + judge.getName() + "  ";
            for(JudgeRole role: judge.getSpecialRoles()){
                result += role;
            }
            result += "\n";
        }
        result += "\n";
        return result;
    }
}
