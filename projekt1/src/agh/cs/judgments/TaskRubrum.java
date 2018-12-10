package agh.cs.judgments;

public class TaskRubrum {

    public void execute(Parser parser, String caseNumber){
        Judgment judgment = parser.getJudgments().get(caseNumber);
        System.out.println("Sygnatura orzeczenia:                 " + judgment.getCaseNumber());
        System.out.println("Data wydania orzeczenia:            " + judgment.getDate());
        System.out.println("Rodzaj sądu:                                " + judgment.getCourtType());
        System.out.print("Sędziowie:                                    ");
        boolean first = true;
        for(Judge judge: judgment.getJudges()){
            if(first) {
                System.out.print(judge.getName() + "  ");
                first = false;
            }
            else
                System.out.print("                                                     " + judge.getName() + "  ");
            for(JudgeRole role: judge.getSpecialRoles()){
                System.out.print(role);
            }
            System.out.print("\n");
        }
    }
}
