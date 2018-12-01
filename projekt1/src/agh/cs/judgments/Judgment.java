package agh.cs.judgments;

import java.util.LinkedList;

public class Judgment {
    private int id;
    private CourtType courtType;
    private LinkedList<Judge> judges;
    private LinkedList<String> courtCases;
    private LinkedList<Regulation> referencedRegulations;
    private Date date;

}
