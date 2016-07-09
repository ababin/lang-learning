package ru.babin.langlearn.ui;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

//VS4E -- DO NOT REMOVE THIS LINE!
public class MyPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel0;
    private JButton jButton0;
    private JList jList0;
    private JScrollPane jScrollPane0;
    private JRadioButton jRadioButton0;
    private JCheckBox jCheckBox0;
    private JButton jButton1;
    private JSeparator jSeparator0;

    public MyPanel() {
        initComponents();
    }

    private void initComponents() {
    	setLayout(new GroupLayout());
    	add(getJLabel0(), new Constraints(new Leading(50, 10, 10), new Leading(24, 10, 10)));
    	add(getJButton0(), new Constraints(new Leading(186, 10, 10), new Leading(19, 12, 12)));
    	add(getJScrollPane0(), new Constraints(new Leading(37, 100, 10, 10), new Leading(66, 135, 10, 10)));
    	add(getJRadioButton0(), new Constraints(new Leading(175, 12, 12), new Leading(72, 10, 10)));
    	add(getJCheckBox0(), new Constraints(new Leading(186, 12, 12), new Leading(123, 10, 10)));
    	add(getJButton1(), new Constraints(new Leading(190, 12, 12), new Leading(164, 12, 12)));
    	add(getJSeparator0(), new Constraints(new Leading(149, 156, 12, 12), new Leading(210, 10, 10, 10)));
    	setSize(320, 240);
    }

    private JSeparator getJSeparator0() {
    	if (jSeparator0 == null) {
    		jSeparator0 = new JSeparator();
    	}
    	return jSeparator0;
    }

    private JButton getJButton1() {
    	if (jButton1 == null) {
    		jButton1 = new JButton();
    		jButton1.setText("jButton1");
    	}
    	return jButton1;
    }

    private JCheckBox getJCheckBox0() {
    	if (jCheckBox0 == null) {
    		jCheckBox0 = new JCheckBox();
    		jCheckBox0.setText("jCheckBox0");
    	}
    	return jCheckBox0;
    }

    private JRadioButton getJRadioButton0() {
    	if (jRadioButton0 == null) {
    		jRadioButton0 = new JRadioButton();
    		jRadioButton0.setText("jRadioButton0");
    	}
    	return jRadioButton0;
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

    private JButton getJButton0() {
    	if (jButton0 == null) {
    		jButton0 = new JButton();
    		jButton0.setText("jButton0");
    	}
    	return jButton0;
    }

    private JLabel getJLabel0() {
    	if (jLabel0 == null) {
    		jLabel0 = new JLabel();
    		jLabel0.setText("jLabel0");
    	}
    	return jLabel0;
    }

}
