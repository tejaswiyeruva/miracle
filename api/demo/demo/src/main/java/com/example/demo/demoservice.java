package com.example.demo;

import org.springframework.stereotype.Service;
@Service
public class demoservice {
    //method that returns cube of the given number  
    public int cube(demo n){  
        return n.getN()*n.getN()*n.getN();  
    }   
}  
