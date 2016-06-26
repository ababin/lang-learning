package ru.babin.langlearn.filter;

public class TrimFilter implements TextFilter{

    @Override
    public String filter(String strIn) {
        if(strIn == null){
            return null;
        }
        String out = strIn.trim();
        return out.isEmpty() ? null : out;
    }
    
}
