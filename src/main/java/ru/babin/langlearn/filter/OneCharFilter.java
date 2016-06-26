package ru.babin.langlearn.filter;

public class OneCharFilter implements TextFilter{

    @Override
    public String filter(String strIn) {
        if(strIn == null){
            return null;
        }
        if(strIn.length() == 1){
            return null;
        }
        return strIn;
    }

}
