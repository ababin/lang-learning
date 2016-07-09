package ru.babin.langlearn.ui;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

//VS4E -- DO NOT REMOVE THIS LINE!
public class MyFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JMenuItem mnuOpenFile;
    private JMenu mnuMain;
    private JMenuBar mnuBar;
    private JPanel jPanel1;
    private JLabel jLabel0;
    private JLabel jLabel1;
    private JButton jButton0;
    private JPanel jPanel2;
    private JList jList0;
    private JScrollPane jScrollPane0;
    private JPanel jPanel3;
    public MyFrame() {
        initComponents();
    }

    private void initComponents() {
    	setLayout(new GroupLayout());
    	add(getJPanel1(), new Constraints(new Leading(8, 683, 10, 10), new Leading(7, 39, 10, 10)));
    	add(getJPanel2(), new Constraints(new Leading(8, 682, 12, 12), new Leading(52, 275, 10, 10)));
    	add(getJPanel3(), new Constraints(new Leading(8, 682, 12, 12), new Leading(335, 29, 10, 10)));
    	setJMenuBar(getJMenuBar0());
    	setSize(698, 396);
    }

    private JPanel getJPanel3() {
    	if (jPanel3 == null) {
    		jPanel3 = new JPanel();
    		jPanel3.setBorder(new LineBorder(Color.black, 1, false));
    		jPanel3.setLayout(new GroupLayout());
    	}
    	return jPanel3;
    }

    private JScrollPane getJScrollPane0() {
    	if (jScrollPane0 == null) {
    		jScrollPane0 = new JScrollPane();
    		jScrollPane0.setViewportView(getJList0());
    	}
    	return jScrollPane0;
    }

    private JList getJList0() {
    	if (jList0 == null) {
    		jList0 = new JList();
    		DefaultListModel listModel = new DefaultListModel();
    		listModel.addElement("item0");
    		listModel.addElement("item1");
    		listModel.addElement("item2");
    		listModel.addElement("item3");
    		jList0.setModel(listModel);
    	}
    	return jList0;
    }

    private JPanel getJPanel2() {
    	if (jPanel2 == null) {
    		jPanel2 = new JPanel();
    		jPanel2.setBorder(new LineBorder(Color.black, 1, false));
    		jPanel2.setLayout(new GroupLayout());
    		jPanel2.add(getJButton0(), new Constraints(new Leading(239, 299, 10, 10), new Leading(11, 12, 12)));
    		jPanel2.add(getJScrollPane0(), new Constraints(new Leading(13, 172, 10, 10), new Bilateral(11, 12, 22)));
    	}
    	return jPanel2;
    }

    private JButton getJButton0() {
    	if (jButton0 == null) {
    		jButton0 = new JButton();
    		jButton0.setText("jButton0");
    	}
    	return jButton0;
    }

    private JLabel getJLabel1() {
    	if (jLabel1 == null) {
    		jLabel1 = new JLabel();
    		jLabel1.setText("......");
    	}
    	return jLabel1;
    }

    private JLabel getJLabel0() {
    	if (jLabel0 == null) {
    		jLabel0 = new JLabel();
    		jLabel0.setText("Selected file: ");
    	}
    	return jLabel0;
    }

    private JPanel getJPanel1() {
    	if (jPanel1 == null) {
    		jPanel1 = new JPanel();
    		jPanel1.setBorder(new LineBorder(Color.black, 1, false));
    		jPanel1.setLayout(new GroupLayout());
    		jPanel1.add(getJLabel0(), new Constraints(new Leading(12, 92, 10, 10), new Leading(12, 12, 12)));
    		jPanel1.add(getJLabel1(), new Constraints(new Bilateral(112, 12, 24), new Leading(12, 12, 12)));
    	}
    	return jPanel1;
    }

    private JMenu getJMenu0() {
    	if (mnuMain == null) {
    		mnuMain = new JMenu();
    		mnuMain.setText("File");
    		mnuMain.add(getJMenuItem0());
    	}
    	return mnuMain;
    }

    private JMenuItem getJMenuItem0() {
    	if (mnuOpenFile == null) {
    		mnuOpenFile = new JMenuItem();
    		mnuOpenFile.setText("Open file ...");
    	}
    	return mnuOpenFile;
    }

    private JMenuBar getJMenuBar0() {
    	if (mnuBar == null) {
    		mnuBar = new JMenuBar();
    		mnuBar.add(getJMenu0());
    	}
    	return mnuBar;
    }

}
