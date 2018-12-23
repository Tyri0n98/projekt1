package agh.cs.judgments;

public class TaskContent {

    public void execute(Parser parser, String caseNumber){
        Judgment judgment = parser.getJudgments().get(caseNumber);
        String textContent = judgment.getTextContent();
        textContent = textContent.replaceAll("\\<.*?\\>", "");
        System.out.println(textContent);
    }
}
