/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.babin.langlearn.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import ru.babin.langlearn.core.Mediator;
import ru.babin.langlearn.util.ConfGlobal;

/**
 *
 * @author Alexander Babin
 * @email alexander.babin@gmail.com
 * 
 * 
 */
public class FrmMain extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    JFileChooser fileChooser;
    Mediator     mediator;
        
    
    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        initComponents();
    }
    
    public void postConstruct(){
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(ConfGlobal.getAppDir()));
        
        pnlImport.setVisible(false);
        
        mediator = new Mediator();
        mediator.setFrmMain(this);
        mediator.init();
    }
            
    public void eventNewLoadedFile(String filePath , List <String> unknownWords, int totalWords){
        lstUnknownWords.setListData(unknownWords.toArray(new String[unknownWords.size()]));
        lblUnknownWordsCount.setText(String.valueOf(unknownWords.size()) + " from " + totalWords);
        lblOpenFile.setText("Opened file: " + filePath);
    }
    
    public void eventVocabularyLoaded(int vocabularySize){
        lblVocabularyInfo.setText(vocabularySize + "");
    }

    
    private void mnuItemOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemOpenFileActionPerformed
        String filename= "";
        String dir = "";
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
          filename = fileChooser.getSelectedFile().getName();
          dir = fileChooser.getCurrentDirectory().toString();
        }
                        
        if(!filename.isEmpty()){
            mediator.eventOpenNewFile(dir + File.separator + filename);
        }
        
    }//GEN-LAST:event_mnuItemOpenFileActionPerformed
    
    
    private void btnAddToVocActionPerformed(java.awt.event.ActionEvent evt) {                                            
        int [] indexes = lstUnknownWords.getSelectedIndices(); 
        List <String> list = new ArrayList<>(indexes.length);
        if(indexes.length > 0){
            for(int i : indexes){
                list.add(lstUnknownWords.getModel().getElementAt(i));
            }
            mediator.eventAddToVocabulary(list);
            mediator.init();
            mediator.eventOpenNewFile(mediator.getFileName());
        }
    }

    private void lstUnknownWordsValueChanged(javax.swing.event.ListSelectionEvent evt) {                                             
        int [] indexes = lstUnknownWords.getSelectedIndices(); 
        if(indexes.length > 0){
            pnlImport.setVisible(true);
            lblImportCount.setText("" + indexes.length);
        }else{
            pnlImport.setVisible(false);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /* =======================================================================================================
     * =======================================================================================================
     * =======================================================================================================
     * =======================================================================================================
     * =======================================================================================================
     * =======================================================================================================
     */
     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMiddle = new javax.swing.JPanel();
        scrlUnknownWords = new javax.swing.JScrollPane();
        lstUnknownWords = new javax.swing.JList<>();
        lblUnknownWords = new javax.swing.JLabel();
        lblUnknownWordsCount = new javax.swing.JLabel();
        lblOpenFile = new javax.swing.JLabel();
        pnlImport = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblImportCount = new javax.swing.JLabel();
        btnAddToVoc = new javax.swing.JButton();
        pnlBottom = new javax.swing.JPanel();
        lblVocabulary = new javax.swing.JLabel();
        lblVocabularyInfo = new javax.swing.JLabel();
        mnuBar = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuItemOpenFile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Foreign languages learning :)");
        setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        setMaximumSize(new java.awt.Dimension(400, 2000));
        setMinimumSize(new java.awt.Dimension(500, 300));

        pnlMiddle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        scrlUnknownWords.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lstUnknownWords.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lstUnknownWords.setToolTipText("Unknown words list");
        lstUnknownWords.setMaximumSize(new java.awt.Dimension(36, 0));
        lstUnknownWords.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUnknownWordsValueChanged(evt);
            }
        });
        scrlUnknownWords.setViewportView(lstUnknownWords);

        lblUnknownWords.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblUnknownWords.setText("Unknown words");

        lblUnknownWordsCount.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUnknownWordsCount.setText("0");

        lblOpenFile.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblOpenFile.setForeground(new java.awt.Color(0, 0, 0));
        lblOpenFile.setText("...");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Selected: ");

        lblImportCount.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblImportCount.setText("0");

        btnAddToVoc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAddToVoc.setText("Add to vocabulary");
        btnAddToVoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToVocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlImportLayout = new javax.swing.GroupLayout(pnlImport);
        pnlImport.setLayout(pnlImportLayout);
        pnlImportLayout.setHorizontalGroup(
            pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddToVoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlImportLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblImportCount, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 37, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlImportLayout.setVerticalGroup(
            pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblImportCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddToVoc)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMiddleLayout = new javax.swing.GroupLayout(pnlMiddle);
        pnlMiddle.setLayout(pnlMiddleLayout);
        pnlMiddleLayout.setHorizontalGroup(
            pnlMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMiddleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOpenFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMiddleLayout.createSequentialGroup()
                        .addGroup(pnlMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMiddleLayout.createSequentialGroup()
                                .addComponent(lblUnknownWords)
                                .addGap(28, 28, 28)
                                .addComponent(lblUnknownWordsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlMiddleLayout.createSequentialGroup()
                                .addComponent(scrlUnknownWords, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlMiddleLayout.setVerticalGroup(
            pnlMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMiddleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOpenFile)
                .addGap(13, 13, 13)
                .addGroup(pnlMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnknownWords)
                    .addComponent(lblUnknownWordsCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrlUnknownWords, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlBottom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        lblVocabulary.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblVocabulary.setText("Vocabulary");

        lblVocabularyInfo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblVocabularyInfo.setText("...");

        javax.swing.GroupLayout pnlBottomLayout = new javax.swing.GroupLayout(pnlBottom);
        pnlBottom.setLayout(pnlBottomLayout);
        pnlBottomLayout.setHorizontalGroup(
            pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVocabulary)
                .addGap(18, 18, 18)
                .addComponent(lblVocabularyInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlBottomLayout.setVerticalGroup(
            pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVocabulary)
                    .addComponent(lblVocabularyInfo))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        mnuFile.setText("File");
        mnuFile.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        mnuItemOpenFile.setText("Open file ...");
        mnuItemOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemOpenFileActionPerformed(evt);
            }
        });
        mnuFile.add(mnuItemOpenFile);

        mnuBar.add(mnuFile);

        setJMenuBar(mnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMiddle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMiddle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmMain frm = new FrmMain();
                frm.postConstruct();
                frm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToVoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblImportCount;
    private javax.swing.JLabel lblOpenFile;
    private javax.swing.JLabel lblUnknownWords;
    private javax.swing.JLabel lblUnknownWordsCount;
    private javax.swing.JLabel lblVocabulary;
    private javax.swing.JLabel lblVocabularyInfo;
    private javax.swing.JList<String> lstUnknownWords;
    private javax.swing.JMenuBar mnuBar;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuItemOpenFile;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlImport;
    private javax.swing.JPanel pnlMiddle;
    private javax.swing.JScrollPane scrlUnknownWords;
    // End of variables declaration//GEN-END:variables
}
