package ru.babin.langlearn.filter;

public class NumberFilter implements TextFilter{

    @Override
    public String filter(String strIn) {
        if(strIn == null){
            return null;
        }
        String out = strIn.replace("0", "").replace("1", "").replace("2", "").replace("3", "").replace("4", "")
            .replace("5", "").replace("6", "").replace("7", "").replace("8", "").replace("9", "");
                
        if(out.trim().isEmpty()){
            return null;
        }
        return out;
    }

}
