package agh.cs.judgments;

import java.util.HashMap;

public class TaskContent {

    public String execute(HashMap<String, Judgment> judgments, String caseNumber){
        Judgment judgment;
        if(judgments.containsKey(caseNumber))
            judgment= judgments.get(caseNumber);
        else
            return "Nie istnieje orzeczenie o sygnaturze: " + caseNumber;
        String textContent = judgment.getTextContent();
        textContent = textContent.replaceAll("\\<.*?\\>", "");
        return textContent;
    }
}
