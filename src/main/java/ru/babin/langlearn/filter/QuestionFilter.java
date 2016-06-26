package ru.babin.langlearn.filter;

public class QuestionFilter implements TextFilter{

    @Override
    public String filter(String strIn) {
        if(strIn == null){
            return null;
        }
        String out = strIn.replace("?", "").replace("!", "");
                        
        if(out.trim().isEmpty()){
            return null;
        }
        return out;
    }

}
