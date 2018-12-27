package agh.cs.judgments;

public class ToEnum {

    public static JudgeRole toJudgeRole(String role){
        switch (role){
            case "PRESIDING_JUDGE": return JudgeRole.PRESIDING_JUDGE;
            case "REPORTING_JUDGE": return JudgeRole.REPORTING_JUDGE;
            case "REASONS_FOR_JUDGMENT_AUTHOR": return JudgeRole.REASONS_FOR_JUDGMENT_AUTHOR;
            case "sprawozdawca": return JudgeRole.REPORTING_JUDGE;
            case "przewodniczący": return JudgeRole.PRESIDING_JUDGE;
            default: throw new IllegalArgumentException(role + " is not legal value");
        }
    }

    public static JudgmentType toType(String type){
        switch (type){
            case "SENTENCE": return JudgmentType.SENTENCE;
            case "DECISION": return JudgmentType.DECISION;
            case "REASONS": return JudgmentType.REASONS;
            case "REGULATION": return JudgmentType.REGULATION;
            default: throw new IllegalArgumentException(type + " is not legal value");
        }
    }

    public static CourtType toCourtType(String type){
        switch (type){
            case "COMMON": return CourtType.COMMON;
            case "SUPREME": return CourtType.SUPREME;
            case "CONSTITUTIONAL_TRIBUNAL": return CourtType.CONSTITUTIONAL_TRIBUNAL;
            case "NATIONAL_APPEAL_CHAMBER": return CourtType.NATIONAL_APPEAL_CHAMBER;
            default: {
                if(type.contains("Wojewódzki")) return CourtType.VOIVODESHIP_ADMINISTRATIVE;
                if(type.contains("Naczelny")) return CourtType.SUPREME_ADMINISTRATIVE;
                throw new IllegalArgumentException(type + " is not legal value");
            }
        }
    }

    public static TaskName toTask(String task){
        switch (task){
            case "rubrum": return TaskName.RUBRUM;
            case "help": return TaskName.HELP;
            case "content": return TaskName.CONTENT;
            case "judge": return TaskName.JUDGE;
            case "judges": return TaskName.JUDGES;
            case "months": return TaskName.MONTHS;
            case "courts": return TaskName.COURTS;
            case "regulations": return TaskName.REGULATIONS;
            case "jury": return TaskName.JURY;
            case "quit": return TaskName.QUIT;
            case "": return TaskName.EMPTY;
            default: return TaskName.ERROR;
        }
    }

   public static Month toMonth(String month){
        switch (month){
            case "01": return Month.JANUARY;
            case "02": return Month.FEBRUARY;
            case "03": return Month.MARCH;
            case "04": return Month.APRIL;
            case "05": return Month.MAY;
            case "06": return Month.JUNE;
            case "07": return Month.JULY;
            case "08": return Month.AUGUST;
            case "09": return Month.SEPTEMBER;
            case "10": return Month.OCTOBER;
            case "11": return Month.NOVEMBER;
            case "12": return Month.DECEMBER;
            default: throw new IllegalArgumentException(month + "is not legal value");
        }
   }
}
