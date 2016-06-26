package ru.babin.langlearn.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import ru.babin.langlearn.util.ConfGlobal;

public class Vocabulary {
        
    private final String VOC_DIR = "vocabulary";
    
    private List<String> vocabulary;
        
    public void load() throws IOException{
        Path path = FileSystems.getDefault().getPath(ConfGlobal.getAppDir()+File.separator+VOC_DIR);
        List <Path> files = scanDir(path);
        
        Set <String> set = new TreeSet<>();
        for(Path p : files){
            try(Scanner s = new Scanner(p.toFile())){
                while(s.hasNext()){
                    set.add(s.next().toLowerCase());
                }
            }
        }
        vocabulary = new ArrayList<>(set);
    }
    
    public List<String> getVocabulary(){
        return vocabulary;
    }
    
    private List<Path> scanDir(Path directory) throws IOException {
        List<Path> all = new LinkedList<>();
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                all.add(file);
                return FileVisitResult.CONTINUE;
            }
        });
        return all;
    }
    
    
}
