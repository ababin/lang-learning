package ru.babin.langlearn.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import ru.babin.langlearn.filter.HtmlTagFilter;
import ru.babin.langlearn.filter.OneCharFilter;
import ru.babin.langlearn.filter.PostfixFilter;
import ru.babin.langlearn.filter.SymbolsOnlyFilter;
import ru.babin.langlearn.filter.TextFilter;
import ru.babin.langlearn.filter.TrimFilter;

public class FileProcessor {
    
    private List <TextFilter> filters = new LinkedList<>();
    
    private HtmlTagFilter htmlTagFilter = new HtmlTagFilter();
    
    private String loadedFilePath = "";
    
    public FileProcessor(){
        
        filters.add(new TrimFilter());
        filters.add(new SymbolsOnlyFilter());
        filters.add(new PostfixFilter());
        filters.add(new OneCharFilter());
        //filters.add(new BracketFilter());
        //filters.add(new DoubleQuoteFilter());
        //filters.add(new SpecialCharsFilter());
        //filters.add(new QuoteSFilter());
        //filters.add(new QuestionFilter());
        //filters.add(new NegationFilter());
        
        //filters.add(new NumberFilter());
    }
    
    public List <String> process(String filePath) throws FileNotFoundException{
        loadedFilePath = filePath;
        List <String> res = new LinkedList<>();
        try(Scanner s = new Scanner(new File(filePath))){
            while(s.hasNextLine()){
                for(String str : processLine(s.nextLine())){
                    if(!res.contains(str)){
                        res.add(str);
                    }
                }
            }
        }
        
        return res;
    }
    
    private List <String> processLine(String lineIn){
        String line = htmlTagFilter.filter(lineIn);
        List <String> res = new LinkedList<>();
        if(line == null || line.isEmpty()){
            return res;
        }
        for(String token : line.split(" ")){
            String filtered = doFilter(token);
            if(filtered != null){
                if(!res.contains(filtered)){
                    res.add(filtered.toLowerCase());
                }
            }
        }
        return res;
    }
    
    private String doFilter(String token) {
        String out = token;
        for(TextFilter filter: filters){
            out = filter.filter(out);
        }
        return out;
    }
    
    public String getFilePath(){
        return loadedFilePath;
    } 
    
    
}
