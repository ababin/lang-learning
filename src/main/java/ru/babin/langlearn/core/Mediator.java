package ru.babin.langlearn.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import ru.babin.langlearn.ui.FrmMain;


/**
 * 
 * @author Aelxander Babin
 * @email alexander.babin@gmail.com
 *
 */
public class Mediator {
    
    // UI components -----------------------------------------------------
    private FrmMain form;
    public void setFrmMain(FrmMain frm){form = frm;}
    // -------------------------------------------------------------------
            
    Vocabulary vocabulary = new Vocabulary();
    
    FileProcessor fileProcessor = new FileProcessor();
    
    public void init(){
        try {
            vocabulary.load();
            form.eventVocabularyLoaded(vocabulary.getWords().size());
        } catch (IOException e) {
            showErrorDialog("Unknown error: " + e.getMessage());
        }
    }
                
    public void eventAddToVocabulary(List <String> vals){
        try {
            vocabulary.add(vals, fileProcessor.getFilePath());
        } catch (FileNotFoundException e) {
            showErrorDialog("Vocabulary file: " + fileProcessor.getFilePath() + " does not exist!");
        }
    }
    
    public void eventOpenNewFile(String filePath){
        try {
            List<String> fileWords = fileProcessor.process(filePath);
            List <String> unknownWords = vocabulary.obtainUnknownWords(fileWords);
            form.eventNewLoadedFile(filePath, unknownWords, fileWords.size());
        } catch (FileNotFoundException e) {
            showErrorDialog("File: " + filePath + "  does not exist!");
        }
    }
            
    public String getFileName(){
        return fileProcessor.getFilePath();
    }
     
    private void showErrorDialog(String mes){
        JOptionPane.showMessageDialog(null, mes, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
        
}
