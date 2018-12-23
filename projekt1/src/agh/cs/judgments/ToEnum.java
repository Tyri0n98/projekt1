package agh.cs.judgments;

public class ToEnum {

    public static JudgeRole toJudgeRole(String role){
        switch (role){
            case "PRESIDING_JUDGE": return JudgeRole.PRESIDING_JUDGE;
            case "REPORTING_JUDGE": return JudgeRole.REPORTING_JUDGE;
            case "REASONS_FOR_JUDGMENT_AUTHOR": return JudgeRole.REASONS_FOR_JUDGMENT_AUTHOR;
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
            default: throw new IllegalArgumentException(type + " is not legal value");
        }
    }

    public static TaskName toTask(String task){
        switch (task){
            case "rubrum": return TaskName.RUBRUM;
            case "help": return TaskName.HELP;
            case "content": return TaskName.CONTENT;
            case "": return TaskName.EMPTY;
            default: return TaskName.ERROR;
        }
    }
}
