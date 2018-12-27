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
        OutputFile file = new OutputFile();
        try {
            if (args.length > 0) {
                file.setPath(Paths.get(args[0]));
            }
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }
        String input = "";
        do {
            try {
                Terminal terminal = TerminalBuilder.builder().system(true).build();
                LineReader lineReader = LineReaderBuilder.builder().terminal(terminal).build();
                input = lineReader.readLine("Podaj ścieżkę: ");
                Path dir = Paths.get(input);
                Parser parser = new Parser();
                parser.parseDir(dir);
                Solver solver = new Solver(parser.getJudgments());
                while (!input.equals("quit")) {
                    input = lineReader.readLine(">> ");
                    Task task = new Task(input);
                    String output = solver.solve(task);
                    System.out.println(output);
                    file.write(input + "\n");
                    file.write(output);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Podana ścieżka nie istnieje");
            }
        }while(!input.equals("quit"));
    }
}