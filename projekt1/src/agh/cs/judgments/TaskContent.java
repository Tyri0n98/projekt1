package agh.cs.judgments;

import java.util.HashMap;

public class TaskContent {

    public void execute(HashMap<String, Judgment> judgments, String caseNumber){
        Judgment judgment;
        if(judgments.containsKey(caseNumber))
            judgment= judgments.get(caseNumber);
        else {
            System.out.println("Nie istnieje orzeczenie o sygnaturze: " + caseNumber);
            return;
        }
        String textContent = judgment.getTextContent();
        textContent = textContent.replaceAll("\\<.*?\\>", "");
        System.out.println(textContent);
    }
}
