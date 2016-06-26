package ru.babin.langlearn.filter;

public class SpecialCharsFilter implements TextFilter{

    @Override
    public String filter(String strIn) {
        if(strIn == null){
            return null;
        }
        String out = strIn.replace("\n", "");
        out = out.replace("\t", "");
        out = out.replace(",", "");
        out = out.replace(";", "");
        out = out.replace(":", "");
        out = out.replace(".", "");
        out = out.replace("...", "");
        out = out.replace("…", "");
        
        if(out.length() == 1
                && out.equals("-")){
            return null;
        }
        return out;
    }

}
