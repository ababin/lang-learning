package ru.babin.langlearn.filter;

public class QuoteSFilter implements TextFilter{

    @Override
    public String filter(String strIn) {
        if(strIn == null){
            return null;
        }
        String out = strIn.replace("'s", "");
                
        if(out.trim().isEmpty()){
            return null;
        }
        return out;
    }

}
