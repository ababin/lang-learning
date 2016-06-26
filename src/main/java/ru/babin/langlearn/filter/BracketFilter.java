package ru.babin.langlearn.filter;

public class BracketFilter implements TextFilter{

    @Override
    public String filter(String strIn) {
        if(strIn == null){
            return null;
        }
        String out = strIn.replace("(", "").replace(")", "").replace("[", "").replace("]", "");
                        
        if(out.trim().isEmpty()){
            return null;
        }
        return out;
    }

}
