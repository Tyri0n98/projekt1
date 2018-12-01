package agh.cs.judgments;

public class Regulation {
    private String journalTitle;
    private int journalNo;
    private int journalYear;
    private int journalEntry;
    private String text;

    public Regulation(String title, int no, int year, int entry, String text){
        this.journalTitle = title;
        this.journalNo = no;
        this.journalYear = year;
        this.journalEntry = entry;
        this.text = text;
    }
}
