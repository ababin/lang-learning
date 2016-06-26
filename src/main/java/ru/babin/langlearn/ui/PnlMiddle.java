package ru.babin.langlearn.ui;

import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import ru.babin.langlearn.core.Mediator;
import ru.babin.langlearn.core.Vocabulary;
import ru.babin.langlearn.util.ConfGlobal;

public class PnlMiddle extends UIPanel{
    
    private static final long serialVersionUID = 1L;
    
    JButton       btnAddToKnown;
    JList<String> lstWords;
    
    
    public PnlMiddle(Mediator mediator){
        super(mediator , ConfGlobal.FLOW_LAYOUT_DEFAULT);
        mediator.registerPanelMiddle(this);
        
    }
    
    protected void initComponents(){
        initLstWords();
        initBtnAddToKnown();
    }
    
    protected void initEvents() {
        
    }
    
    private void initLstWords(){
        lstWords = new JList<>();
        lstWords.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        lstWords.setVisibleRowCount(5);
        lstWords.setFont(ConfGlobal.FONT_DEFAULT);
        lstWords.setVisibleRowCount(20);
        lstWords.setFixedCellWidth(150);
        lstWords.setFixedCellHeight(16);
        
        JScrollPane listScroller = new JScrollPane(lstWords);
        listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        listScroller.setVisible(true);
        add(listScroller);
    }
    
    private void initBtnAddToKnown(){
                
        JPanel pan2 = new JPanel(ConfGlobal.BORDER_LAYOUT_DEFAULT);
        add(pan2);
        
        btnAddToKnown = new JButton();
        btnAddToKnown.setText("Add to known words");
        btnAddToKnown.setFont(ConfGlobal.FONT_DEFAULT);
        pan2.add(btnAddToKnown, BorderLayout.NORTH);
        pan2.add(Box.createVerticalStrut(270), BorderLayout.SOUTH);
                
    }

    public void setFoundWords(List <String> words){
        int foundWordsCount = words.size();
        
        Vocabulary vocabulary = mediator.getVocabulary();
        List <String> onlyUnknownWords = new LinkedList<>();
        for(String word : words){
            if(!vocabulary.getVocabulary().contains(word.toLowerCase())){
                onlyUnknownWords.add(word);
            }
        }
                
        //String [] ar = Arrays.asList(a)
        lstWords.setListData(onlyUnknownWords.toArray(new String[onlyUnknownWords.size()]));
        
        mediator.setUnknownWordsCounter(onlyUnknownWords.size());
        mediator.setFoundWordsCount(foundWordsCount);
    }

    @Override
    protected void postInit() {
        // TODO Auto-generated method stub
        
    }
    
}
