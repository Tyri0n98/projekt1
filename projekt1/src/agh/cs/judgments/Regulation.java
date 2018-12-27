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

    public Regulation(String title){
        this.journalTitle = title;
        this.journalNo = "";
        this.journalYear = "";
        this.journalEntry = "";
        this.text = "";
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public String getJournalNo() {
        return journalNo;
    }

    public String getJournalYear() {
        return journalYear;
    }

    public String getJournalEntry() {
        return journalEntry;
    }

    public String getText() {
        return text;
    }
}
