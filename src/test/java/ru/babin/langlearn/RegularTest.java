package ru.babin.langlearn;

import org.junit.Assert;
import org.junit.Test;



public class RegularTest {
    
    
    @Test
    public void testRegular(){
        String someText = "and some text";
        String strIn ="<font color=\"#ffff00\" size=14>" + someText;
        
        String out = strIn.replaceAll("\\<.*?>","");
        Assert.assertEquals(out, someText);
    }
    
    @Test
    public void testRegular2(){
        
        String strIn ="<font color=\"#ffff00\" size=14>www.tvsubtitles.net</font>";
        
        String out = strIn.replaceAll("\\<.*?>","");
        Assert.assertEquals(out, "www.tvsubtitles.net");
    }
    
    
    
    
}
