package agh.cs.judgments;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args){
        try {
            Terminal terminal = TerminalBuilder.builder().system(true).build();
            LineReader lineReader = LineReaderBuilder.builder().terminal(terminal).build();
            String input;
            input=lineReader.readLine("Podaj ścieżkę: ");
            Path dir = Paths.get(input);
            Parser parser = new Parser();
            parser.parseDir(dir);
            Solver solver = new Solver(parser.getJudgments());
            while(!input.equals("quit")) {
                input = lineReader.readLine(">> ");
                Task task = new Task(input);
                System.out.println(task.getTaskName());
                System.out.println(task.getArgs());
                solver.solve(task);

            }
        }catch(ParseException | IOException e){
            e.printStackTrace();
        }
    }
}