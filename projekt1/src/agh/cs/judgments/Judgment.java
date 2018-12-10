package agh.cs.judgments;

import java.util.LinkedList;

public class Judgment {
    private String id;
    private String caseNumber;
    private CourtType courtType;
    private LinkedList<Judge> judges;
    private LinkedList<Regulation> referencedRegulations;
    private Date date;

    public Judgment(String id, String caseNumber, CourtType courtType, LinkedList<Judge> judges, LinkedList<Regulation> referencedRegulations, Date date){
        this.id = id;
        this.caseNumber = caseNumber;
        this.courtType = courtType;
        this.judges = judges;
        this.referencedRegulations = referencedRegulations;
        this.date = date;
    }
}
