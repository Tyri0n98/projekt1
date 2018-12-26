package agh.cs.judgments;

import java.util.HashMap;

public class Solver {
    private HashMap<String, Judgment> judgments;

    public Solver(HashMap<String, Judgment> judgments){
        this.judgments = judgments;
    }

    public String solve(Task task){
        TaskName taskName = task.getTaskName();
        switch (taskName){
            case RUBRUM:{
                if (task.getArgs().isEmpty()) return "Nie podano argumentów";
                String result="";
                for(String arg: task.getArgs()) {
                TaskRubrum taskRubrum = new TaskRubrum();
                result += taskRubrum.execute(judgments, arg);
                }
                return result;
            }
            case CONTENT:{
                if(task.getArgs().isEmpty()) return "Nie podano argumentów";
                String result = "";
                for(String arg: task.getArgs()){
                    TaskContent taskContent = new TaskContent();
                    result += taskContent.execute(judgments, arg);
                }
                return result;
            }
            case JUDGE:{
                TaskJudge taskJudge = new TaskJudge(task.getArgs().getFirst(), judgments);
                return taskJudge.execute();
            }
            case JUDGES:{
                TaskJudges taskJudges = new TaskJudges(judgments);
                return taskJudges.execute();
            }
            case MONTHS:{
                TaskMonths taskMonths = new TaskMonths(judgments);
                return taskMonths.execute();
            }
            case COURTS:{
                TaskCourts taskCourts = new TaskCourts(judgments);
                return taskCourts.execute();
            }
            case REGULATIONS:{
                TaskRegulations taskRegulations = new TaskRegulations(judgments);
                return taskRegulations.execute();
            }
            case JURY:{
                TaskJury taskJury = new TaskJury(judgments);
                return taskJury.execute();
            }
            case HELP:{
                return "Argumenty do poleceń podaje się w cudzysłowach i oddziela spacjami\nrubrum - wyświetlenie metryki jednego lub wielu orzeczeń na podstawie sygnatury \ncontent - wyświetlenie uzasadnienia jednego lub wielu orzeczeń na podstawie sygnatury\njudge - wyświetla liczbę orzeczeń dla wybranego sędziego\njudges - wyświetla 10 sędziów, którzy wydali najwięcej orzeczeń\nmonths - wyświetla liczbę orzeczeń wydanych w poszczególnych miesiącach\ncourts - wyświetla liczbę orzeczeń ze względu na typ sądu\nregulations - wyświetla 10 najczęściej przywoływanych ustaw\njury - wyświetla lcizbę spraw przypadającą na określoną liczbę sędziów\n ";
            }
            case ERROR:{
                return "Polecenie " + task.getInput() + " nie istnieje" + "\n";
            }
            default: return "";
        }
    }

}
