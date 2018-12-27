package agh.cs.judgments;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputFile {
    private Path path;
    private boolean isFile;

    public void setPath(Path path) throws IllegalAccessException{
        if(!Files.exists(path)){
            throw new IllegalAccessException(path.toString() + " doesn't exists");
        }
        this.path = path;
        this.isFile = true;
    }

    public OutputFile(){
        this.isFile = false;
    }

    public void write(String output) throws IOException {
        if(!isFile) return;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.path.toString(), true));
        bufferedWriter.write(output);
        bufferedWriter.close();
    }
}
