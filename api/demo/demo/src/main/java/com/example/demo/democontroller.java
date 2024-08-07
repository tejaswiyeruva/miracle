package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/demo")

public class democontroller {
    @Autowired
    demoservice ps;

    @PostMapping("/select")
    public int cube(@RequestBody demo d) {       
        return ps.cube(d);
    }

}
