package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
public class testing {
    @Autowired
    democontroller obj;
    @Test  
    public void cube(){  
        demo d=new demo();
        d.setN(2);
        assertEquals(8,obj.cube(d)); 
    }  
}