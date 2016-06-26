package ru.babin.langlearn.util;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;

public class ConfGlobal {
    
    public static final Font FONT_DEFAULT = new Font("Verdana", Font.PLAIN, 12);
    public static final Font FONT_BOLD_DEFAULT = new Font("Verdana", Font.BOLD, 12);
    
    public static final LayoutManager FLOW_LAYOUT_DEFAULT =  new FlowLayout(FlowLayout.LEFT, 10, 10);
    
    public static final LayoutManager BORDER_LAYOUT_DEFAULT = new BorderLayout(10,10);
    
    private static String APP_DIR = "";
    
    
    static{
        try {
            APP_DIR = new File( "." ).getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static String getAppDir(){
        return APP_DIR;
    }
    
}
