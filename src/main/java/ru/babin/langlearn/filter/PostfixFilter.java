package ru.babin.langlearn.filter;

public class PostfixFilter implements TextFilter{

    @Override
    public String filter(String strIn) {
        if(strIn == null){
            return null;
        }
        String out = strIn.replace("'m", "").replace("'ll", "").replace("'ve", "");
                
        if(out.trim().isEmpty()){
            return null;
        }
        return out;
    }

}
