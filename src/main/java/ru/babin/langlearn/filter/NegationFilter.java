package ru.babin.langlearn.filter;

public class NegationFilter implements TextFilter{

    @Override
    public String filter(String strIn) {
        if(strIn == null){
            return null;
        }
        String out = strIn.replace("'t", "");
                
        if(out.trim().isEmpty()){
            return null;
        }
        return out;
    }

}
