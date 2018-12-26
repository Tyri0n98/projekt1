package agh.cs.judgments;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args){
        boolean fileArgument = false;
        if(args.length>0) fileArgument = true;
        String input= "";
        do {
            try {
                PrintStream printStream = null;
                if(fileArgument){
                   printStream = new PrintStream(args[0]);
                }
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
                    if(fileArgument){
                        printStream.println(input);
                        printStream.println(output);
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Podana ścieżka nie istnieje");
            }
        }while(!input.equals("quit"));
    }
}