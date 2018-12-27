package agh.cs.judgments;

public enum CourtType {
    COMMON, SUPREME, CONSTITUTIONAL_TRIBUNAL, NATIONAL_APPEAL_CHAMBER, VOIVODESHIP_ADMINISTRATIVE, SUPREME_ADMINISTRATIVE, UNSPECIFIED;

    public String toString(){
        switch (this){
            case COMMON: return "Sąd Powszechny";
            case SUPREME: return "Sąd Najwyższy";
            case CONSTITUTIONAL_TRIBUNAL: return "Trybunał Konstytucyjny";
            case NATIONAL_APPEAL_CHAMBER: return "Krajowa Izba Odwoławcza";
            case VOIVODESHIP_ADMINISTRATIVE: return "Wojewódzki Sąd Administracyjny";
            case SUPREME_ADMINISTRATIVE: return "Naczelny Sąd Administracyjny";
            case UNSPECIFIED: return "Unspecified";
            default: return "";
        }
    }
}
