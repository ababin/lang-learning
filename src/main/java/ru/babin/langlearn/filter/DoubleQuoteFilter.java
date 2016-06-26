package ru.babin.langlearn.filter;

public class DoubleQuoteFilter implements TextFilter{

    @Override
    public String filter(String strIn) {
        if(strIn == null){
            return null;
        }
        return strIn.replace("\"", "").replace("'", "");
    }

}
