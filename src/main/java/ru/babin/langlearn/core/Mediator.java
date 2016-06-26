package ru.babin.langlearn.core;

import java.util.List;

import ru.babin.langlearn.ui.FrmMain;
import ru.babin.langlearn.ui.PnlBottom;
import ru.babin.langlearn.ui.PnlMiddle;
import ru.babin.langlearn.ui.PnlTop;

public class Mediator {
    
    FrmMain    mainForm;
    PnlTop     panelTop;
    PnlMiddle  panelMiddle;
    PnlBottom  panelBottom;
           
        
    public void registerMainForm(FrmMain mainForm){
        this.mainForm = mainForm;
    }
    
    public void registerPanelTop(PnlTop panelTop){
        this.panelTop = panelTop;
    }
    
    public void registerPanelBottom(PnlBottom panelBottom){
        this.panelBottom = panelBottom;
    }
    
    public void registerPanelMiddle(PnlMiddle panelMiddle){
        this.panelMiddle = panelMiddle;
    }
    
    public void setLoadedWords(List <String> words){
        panelMiddle.setFoundWords(words);
    }
    
    public void setVocabularySize(int vocSize){
        panelBottom.setVocabularySize(vocSize);
    }
    
    public void setUnknownWordsCounter(int size){
        panelBottom.setUnknownWordsCount(size);
    }
    
    public Vocabulary getVocabulary(){
        return mainForm.getVocabulary();
    }

    public void setFoundWordsCount(int foundWordsCount) {
        panelBottom.setFoundWordsCount(foundWordsCount);
        
    }
    
}
