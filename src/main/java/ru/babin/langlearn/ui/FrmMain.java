package ru.babin.langlearn.ui;

import java.awt.BorderLayout;
import java.awt.Point;
import java.io.IOException;

import javax.swing.JFrame;

import ru.babin.langlearn.core.Mediator;
import ru.babin.langlearn.core.Vocabulary;

public class FrmMain extends JFrame{
    
    private static final long serialVersionUID = 1L;
        
    final Mediator mediator;
    
    private PnlTop pnlTop;
    
    Vocabulary vocabulary;
    
    public FrmMain(Mediator mediator){
        super("Learning ENGLISH");
        this.mediator = mediator;
        mediator.registerMainForm(this);
        
        initSelf();        
        initPanelTop();
        initPanelMiddle();
        initPanelBottom();
    }
    

    private void initSelf() {
        setLayout(new BorderLayout(10,10));
        //setSize(800, 510);
        setLocation(new Point(200,200));
    }


    private void initPanelTop() {
        pnlTop = new PnlTop(mediator);
        add(pnlTop, BorderLayout.NORTH);
    }
    
    private void initPanelMiddle() {
        PnlMiddle pan = new PnlMiddle(mediator);
        add(pan, BorderLayout.CENTER);
    }

    private void initPanelBottom() {
        PnlBottom pan = new PnlBottom(mediator);
        add(pan, BorderLayout.SOUTH);
    }

    public void postInit() {
        initVocabulary();
    }
    
    private void initVocabulary() {
        try {
            vocabulary = new Vocabulary();
            vocabulary.load();
            mediator.setVocabularySize(vocabulary.getVocabulary().size());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public Vocabulary getVocabulary(){
        return vocabulary;
    }
    
}
