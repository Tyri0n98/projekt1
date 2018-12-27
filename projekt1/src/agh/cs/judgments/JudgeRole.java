package agh.cs.judgments;

public enum JudgeRole {
    PRESIDING_JUDGE, REPORTING_JUDGE, REASONS_FOR_JUDGMENT_AUTHOR;

    public String toString(){
        switch (this){
            case PRESIDING_JUDGE: return "Przewodniczący";
            case REPORTING_JUDGE: return "Sprawozdawca";
            case REASONS_FOR_JUDGMENT_AUTHOR: return "Reasons for judgment author";
            default: return "";
        }
    }
}
