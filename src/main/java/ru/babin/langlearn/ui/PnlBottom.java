package ru.babin.langlearn.ui;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JLabel;

import ru.babin.langlearn.core.Mediator;
import ru.babin.langlearn.util.ConfGlobal;

public class PnlBottom extends UIPanel{
    
    private static final long serialVersionUID = 1L;
    
    static final String FOUND_WORDS_COUNT_TEXT = "Found words";
    static final String UNKNOWN_WORDS_COUNT_TEXT = "Unknown";
    static final String VOC_COUNT_TEXT = "Vocabulary";
    
    JLabel        lblFoundWords;
    JLabel        lblUnknown;
    JLabel        lblVoc;
    
    public PnlBottom(Mediator mediator){
        super(mediator , new FlowLayout(FlowLayout.CENTER, 10, 10));
        mediator.registerPanelBottom(this);
    }
    
    protected void initComponents(){
        initLblFoundWords();
        add(Box.createVerticalStrut(30));
        initLblUnknown();
        add(Box.createVerticalStrut(30));
        initLblVoc();
    }
    
    private void initLblVoc() {
        lblVoc = new JLabel(VOC_COUNT_TEXT);
        lblVoc.setFont(ConfGlobal.FONT_BOLD_DEFAULT);
        setVocabularySize(0);
        add(lblVoc);
    }

    private void initLblUnknown() {
        lblUnknown = new JLabel(UNKNOWN_WORDS_COUNT_TEXT);
        lblUnknown.setFont(ConfGlobal.FONT_BOLD_DEFAULT);
        add(lblUnknown);
    }

    private void initLblFoundWords() {
        lblFoundWords = new JLabel(FOUND_WORDS_COUNT_TEXT);
        lblFoundWords.setFont(ConfGlobal.FONT_BOLD_DEFAULT);
        add(lblFoundWords);
    }

    protected void initEvents() {
        
    }
        
    public void setFoundWordsCount(int count){
        lblFoundWords.setText(FOUND_WORDS_COUNT_TEXT + ": " + count);
    }

    public void setVocabularySize(int vocSize) {
        lblVoc.setText(VOC_COUNT_TEXT + ": " + vocSize);
    }

    @Override
    protected void postInit() {
        // TODO Auto-generated method stub
        
    }

    public void setUnknownWordsCount(int size) {
        lblUnknown.setText(UNKNOWN_WORDS_COUNT_TEXT + ": " + size);
    }
    
}
