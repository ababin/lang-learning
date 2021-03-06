package ru.babin.langlearn.filter;

public class PostfixFilter implements TextFilter{

    @Override
    public String filter(String strIn) {
        if(strIn == null){
            return null;
        }
        String out = strIn
                .replace("'m", "")         // i'm
                .replace("'s", "")         // dady's
                .replace("'d", "")         // I'd
                .replace("'ll", "")        // He'll
                .replace("n't", "")        // I don't
                .replace("'ve", "")        // I've
                .replace("'re", "")        // You're
                .replace("'em", "")        // I just found 'em.
                ;       
                
        if(out.trim().isEmpty()){
            return null;
        }
        
        // check string end
        if(out.endsWith("'")){
            out = out.substring(0, out.length()-1);
        }
        if(out.trim().isEmpty()){
            return null;
        }
        
        return out;
    }

}
