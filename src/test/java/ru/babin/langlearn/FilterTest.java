package ru.babin.langlearn;

import org.junit.Assert;
import org.junit.Test;


import ru.babin.langlearn.filter.DoubleQuoteFilter;

public class FilterTest {
    
    @Test
    public void doubleQuoteFilter(){
        DoubleQuoteFilter f = new DoubleQuoteFilter();
        String s = f.filter("timeframe,\"");
        
        Assert.assertEquals(s, "timeframe,");
        
    }
    
    
}
