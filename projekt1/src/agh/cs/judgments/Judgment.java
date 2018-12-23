package agh.cs.judgments;

import java.util.LinkedList;

public class Judgment {
    private String id;
    private String caseNumber;
    private String textContent;
    private CourtType courtType;
    private LinkedList<Judge> judges;
    private LinkedList<Regulation> referencedRegulations;
    private Date date;

    public Judgment(String id, String caseNumber, String textContent, CourtType courtType, LinkedList<Judge> judges, LinkedList<Regulation> referencedRegulations, Date date){
        this.id = id;
        this.caseNumber = caseNumber;
        this.textContent = textContent;
        this.courtType = courtType;
        this.judges = judges;
        this.referencedRegulations = referencedRegulations;
        this.date = date;
    }

    public String getCaseNumber(){
        return this.caseNumber;
    }

    public String getTextContent() {
        return textContent;
    }

    public String getId() {
        return id;
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public LinkedList<Judge> getJudges() {
        return judges;
    }

    public LinkedList<Regulation> getReferencedRegulations() {
        return referencedRegulations;
    }

    public Date getDate() {
        return date;
    }
}
