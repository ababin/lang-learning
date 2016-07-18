package ru.babin.langlearn.filter;

public class HtmlTagFilter implements TextFilter{

    @Override
    public String filter(String strIn) {
        if(strIn == null){
            return null;
        }
        
        /*
        String out = strIn
                .replace("<i>", "") 
                .replace("</i>", "")
                .replace("<b>", "") 
                .replace("</b>", "")   
                ;       
        */
        String out = strIn.replaceAll("\\<.*?>","");
        
        if(out.trim().isEmpty()){
            return null;
        }
        return out;
    }

}
