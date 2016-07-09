package ru.babin.langlearn.filter;

public class SymbolsOnlyFilter implements TextFilter{

    private static final char [] LETTERS = new char [] {
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
    };  
    
    private static final char[] MISC_CHARS = new char [] {'-','\'' };
    
    
    // left only letters, "'" , "A-Za-z", "-"
    
    @Override
    public String filter(String strIn) {
        if(strIn == null){
            return null;
        }
        // remove '--'
        String strOut = strIn;
        while(strOut.contains("--")){
            strOut = strOut.replace("--", "-");
        }
        
        //
        StringBuilder sb = new StringBuilder();
        for(char c : strOut.toCharArray()){
            if(isAceptableChar(c)){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }

    private boolean isAceptableChar(char charIn){
        for(char c : LETTERS){
            if(c == charIn){
                return true;
            }
        }
        
        for(char c : MISC_CHARS){
            if(c == charIn){
                return true;
            }
        }
        
        return false;
    }
    
}
