package ru.babin.langlearn.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import ru.babin.langlearn.filter.BracketFilter;
import ru.babin.langlearn.filter.DoubleQuoteFilter;
import ru.babin.langlearn.filter.NegationFilter;
import ru.babin.langlearn.filter.NumberFilter;
import ru.babin.langlearn.filter.OneCharFilter;
import ru.babin.langlearn.filter.PostfixFilter;
import ru.babin.langlearn.filter.QuestionFilter;
import ru.babin.langlearn.filter.QuoteSFilter;
import ru.babin.langlearn.filter.SpecialCharsFilter;
import ru.babin.langlearn.filter.SymbolsOnlyFilter;
import ru.babin.langlearn.filter.TextFilter;
import ru.babin.langlearn.filter.TrimFilter;

public class FileProcessor {
    
    private List <TextFilter> filters = new LinkedList<>();
    
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
    
    public List <String> process(String fileName) throws FileNotFoundException{
        List <String> res = new LinkedList<>();
        
        try(Scanner s = new Scanner(new File(fileName))){
            while(s.hasNext()){
                String token = s.next().toLowerCase();
                                
                String filtered = doFilter(token);
                if(filtered != null){
                    if(!res.contains(filtered)){
                        res.add(filtered);
                    }
                }
            }
        }
        
        return res;
    }
    
    public void saveResult(String fileName){
        
    }

    String doFilter(String token) {
        String out = token;
        for(TextFilter filter: filters){
            out = filter.filter(out);
        }
        
        return out;
    }
    
    
}
