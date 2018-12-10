package agh.cs.judgments;

public class Regulation {
    private String journalTitle;
    private String journalNo;
    private String journalYear;
    private String journalEntry;
    private String text;

    public Regulation(String title, String no, String year, String entry, String text){
        this.journalTitle = title;
        this.journalNo = no;
        this.journalYear = year;
        this.journalEntry = entry;
        this.text = text;
    }
}
