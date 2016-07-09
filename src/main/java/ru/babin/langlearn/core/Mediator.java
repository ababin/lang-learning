package ru.babin.langlearn.core;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Mediator {
    
    // ------------------------------------------------------------------------------------------------------------------
    private javax.swing.JList<String> lstUnknownWords;
    public void setLstUnknownWords(javax.swing.JList<String> lstUnknownWords){this.lstUnknownWords = lstUnknownWords;}
    
    private javax.swing.JLabel lblUnknownWordsCount;
    public void setLblUnknownWordsCount(javax.swing.JLabel lblUnknownWordsCount){this.lblUnknownWordsCount = lblUnknownWordsCount;}
    
    private javax.swing.JLabel lblVocabularyInfo;
    public void setLblVocabularyInfo(javax.swing.JLabel lblVocabularyInfo){this.lblVocabularyInfo = lblVocabularyInfo;}
    // ------------------------------------------------------------------------------------------------------------------
    
    Vocabulary vocabulary = new Vocabulary();
    
    public void init(){
        try {
            vocabulary.load();
            lblVocabularyInfo.setText(vocabulary.getVocabulary().size() + "");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
            
    public void eventNewLoadedWords(List <String> words){
        int foundWordsCount = words.size();
                
        List <String> onlyUnknownWords = new LinkedList<>();
        for(String word : words){
            if(!vocabulary.getVocabulary().contains(word.toLowerCase())){
                onlyUnknownWords.add(word);
            }
        }
        lstUnknownWords.setListData(onlyUnknownWords.toArray(new String[onlyUnknownWords.size()]));
        setUnknownWordsCounter(onlyUnknownWords.size(), foundWordsCount);
    }
    
    public void setUnknownWordsCounter(int unknownWords , int totalWords){
        lblUnknownWordsCount.setText(String.valueOf(unknownWords) + " from " + totalWords);
    }
       
        
}
