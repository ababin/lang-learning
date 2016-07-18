package ru.babin.langlearn.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    
    private List<String> words;
        
    public void load() throws IOException{
        Path path = getVocabularyFolderPath();
        List <Path> files = scanDir(path);
        
        Set <String> set = new TreeSet<>();
        for(Path p : files){
            set.addAll(loadFile(p.toFile()));
        }
        words = new ArrayList<>(set);
    }
    
    private Set <String> loadFile(File f) throws FileNotFoundException{
        Set <String> set = new TreeSet<>();
        try(Scanner s = new Scanner(f)){
            while(s.hasNext()){
                set.add(s.next().toLowerCase());
            }
        }
        return set;
    }
    
    public void add(List <String> vals, String filePathStr) throws FileNotFoundException{
        Path vocFolderPath = getVocabularyFolderPath();
        
        Path filePath = Paths.get(filePathStr);
        String fileName = normalizeFileName(filePath.getFileName().toString());
        File f = new File(vocFolderPath.toString() + File.separator + fileName);
        
        Set <String> resultSet = new TreeSet<>();
        
        if(f.exists()){
            resultSet.addAll(loadFile(f));
        }
        resultSet.addAll(vals);
                
        try(FileWriter fw = new FileWriter(f)){
            for(String val : resultSet){
                fw.write(val + "\n");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    
    public List <String> obtainUnknownWords(List <String> fileWords){
        List <String> unknownWords = new LinkedList<>();
        for(String fileWord : fileWords){
            if(!words.contains(fileWord.toLowerCase())){
                unknownWords.add(fileWord);
            }
        }
        return unknownWords;
    }
    
    private String normalizeFileName(String strIn){
        return strIn.replace("-", "_").replace(" ", "_") + ".voc";
    }
    
    private Path getVocabularyFolderPath(){
        return FileSystems.getDefault().getPath(ConfGlobal.getAppDir()+File.separator+VOC_DIR);
    }
    
    public List<String> getWords(){
        return words;
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
