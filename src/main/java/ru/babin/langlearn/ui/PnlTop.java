package ru.babin.langlearn.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ru.babin.langlearn.core.FileProcessor;
import ru.babin.langlearn.core.Mediator;
import ru.babin.langlearn.util.ConfGlobal;

public class PnlTop extends UIPanel{
    
    private static final long serialVersionUID = 1L;
            
    
    
    JButton btnOpenFile;
    JLabel  lblOpenFile;
    
    
    
    FileProcessor fileProcessor = new FileProcessor();
    JFileChooser fileChooser = new JFileChooser();
    
    
    public PnlTop(Mediator mediator){
        super(mediator , ConfGlobal.FLOW_LAYOUT_DEFAULT);
        fileChooser.setCurrentDirectory(new File(ConfGlobal.getAppDir()));
    }
    
    protected void initComponents(){
        initBtnOpenFile();
        initLabel();
        
    }
        
    private void initBtnOpenFile(){
        btnOpenFile = new JButton();
        btnOpenFile.setText("File ...");
        btnOpenFile.setFont(ConfGlobal.FONT_DEFAULT);
        add(btnOpenFile);
    }
    
    private void initLabel(){
        lblOpenFile = new JLabel();
        lblOpenFile.setFont(ConfGlobal.FONT_DEFAULT);
        lblOpenFile.setText("Path to file");
        add(lblOpenFile);
    }
    
    protected void initEvents() {
        btnOpenFile.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                
                String filename= "";
                String dir = "";
               
                
                // Demonstrate "Open" dialog:
                int res = fileChooser.showOpenDialog(null);
                if (res == JFileChooser.APPROVE_OPTION) {
                  filename = fileChooser.getSelectedFile().getName();
                  dir = fileChooser.getCurrentDirectory().toString();
                }
                
                //JOptionPane.showMessageDialog(null, "filename: " + filename + "  ;  dir: " + dir);
                
                if(!filename.isEmpty()){
                    processSelectedFile(dir + File.separator + filename);
                }
            }
            
        });
        
    }
    
    private void processSelectedFile(String filePath) {
        try {
            List<String> words = fileProcessor.process(filePath);
            mediator.setLoadedWords(words);
            lblOpenFile.setText(filePath);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "filename: " + filePath + "  ;  Error processing !!!");
        }
        
    }

    @Override
    protected void postInit() {}
    
    
    
}
