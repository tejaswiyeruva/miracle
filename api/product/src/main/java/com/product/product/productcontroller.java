package com.product.product;


import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController

@RequestMapping("/product")
public class productcontroller {
    @Autowired
    productservice ps;

    @PostMapping("/i_p")
    public Map addproduct(@RequestBody product p){
        HashMap<String,String> hm=new HashMap<>();
        int add=ps.addproduct(p);
        if(add>0){
            hm.put("s","data inserted");
        }
        else{
            hm.put("f","data not inserted");
        }
        return hm;
    }

    @PostMapping("/u_p")
    public Map updateproduct(@RequestBody product p){
        HashMap<String,String> response=new HashMap<>();
            int updateResult = ps.updateproduct(p);
            if (updateResult > 0) {
                response.put("status", "success");
            } else {
                response.put("status", "failure");
                response.put("message", "Data not updated");
            }
        return response;
    }
    
    @PostMapping("/delete")
    public Map deletes(@RequestBody product p){
        HashMap<String,String> h=new HashMap<>();
        int d=ps.deletes(p);
        if(d>0){
            h.put("s","deleted");
        }
        else{
            h.put("f","data not inserted");
        }
        return h;
    }

    @PostMapping("/selectsa")
    public List selectData() {       
        return ps.selectData();
    }

    @PostMapping("/selects")
    public List data(@RequestBody product s) {
        return ps.fetchData(s);
    }

    @PostMapping("/empsdetails")
    public Map addemp(@RequestBody product p){
        HashMap<String,String> hm=new HashMap<>();
        int add=ps.addemp(p);
        if(add>0){
            hm.put("s","data inserted");
        }
        else{
            hm.put("f","data not inserted");
        }
        return hm;
    }

    @PostMapping("/project")
    public Map project(@RequestBody product p){
        HashMap<String,String> hm=new HashMap<>();
        int add=ps.project(p);
        if(add>0){
            hm.put("s","data inserted");
        }
        else{
            hm.put("f","data not inserted");
        }
        return hm;
    }

    @PostMapping("/empsts")
    public Map AddEmployee(@RequestBody product p){
        HashMap<String,String> hm=new HashMap<>();
        int add=ps.AddEmployee(p);
        if(add>0){
            hm.put("s","data inserted");
        }
        else{
            hm.put("f","data not inserted");
        }
        return hm;
    }
    /*@PostMapping("/empss")
    public Map addps(@RequestBody product p){
        HashMap<String,String> hm=new HashMap<>();
        int add=ps.addps(p);
        if(add>0){
            hm.put("s","data inserted");
        }
        else{
            hm.put("f","data not inserted");
        }
        return hm;
    }

    @PutMapping("/path")
    public int addS(@RequestBody product p){
        int add=ps.addS(p);
        return add;
    }*/

    @GetMapping("/cube/{number}")
    public int cube(@PathVariable int number) {
        return ps.calculateCube(number);
    }
}
