package agh.cs.judgments;

public enum CourtType {
    COMMON, SUPREME, CONSTITUTIONAL_TRIBUNAL, NATIONAL_APPEAL_CHAMBER;

    public String toString(){
        switch (this){
            case COMMON: return "Sąd Powszechny";
            case SUPREME: return "Sąd Najwyższy";
            case CONSTITUTIONAL_TRIBUNAL: return "Trybunał Konstytucyjny";
            case NATIONAL_APPEAL_CHAMBER: return "Krajowa Izba Odwoławcza";
            default: return "";
        }
    }
}
