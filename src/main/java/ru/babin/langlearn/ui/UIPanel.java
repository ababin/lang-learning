package ru.babin.langlearn.ui;

import java.awt.LayoutManager;

import javax.swing.JPanel;

import ru.babin.langlearn.core.Mediator;

public abstract class UIPanel extends JPanel {
    
    private static final long serialVersionUID = 1L;
    
    
    protected final Mediator mediator;
    
    
    public UIPanel(Mediator mediator, LayoutManager layoutManager){
        super(layoutManager);
        this.mediator = mediator;
        initComponents();
        initEvents();
    }
    
    protected abstract void initComponents();
    
    protected abstract void initEvents();
    
    protected abstract void postInit();
    
}
