package com.product.product;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.time.*;
import javax.print.DocFlavor.STRING;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class productservice {
    @Autowired
    JdbcTemplate jdbct;
    public int addproduct(product p){
        int pid=p.getPid();
        String pname=p.getPname();
        float price=p.getPrice();
        String sql="insert into Products values(?,?,?)";
        int i=jdbct.update(sql,pid,pname,price);
        return i;
    }
    public int updateproduct(product p){
        int pid=p.getPid();
        String pname=p.getPname();
        float price=p.getPrice();
        String sql = "update Products set ProductName = ?, Price = ? where ProductID = ?";
        int i=jdbct.update(sql, pname, price, pid);
        return i;
        
    }
    public int deletes(product p){
        int trip=p.getTrip_id();
        String sql="delete from bus_details where trip_id=?";
        int i=jdbct.update(sql,trip);
        return i;
    }



     //using select stament for Student2 table 
    /**
     * @return
     */
    public List selectData(){
        List l = new ArrayList<>();
        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        String sql= "select * from students1";
        data = jdbct.queryForList(sql);
        for (Map m : data) {
            Map<String, Object> ma = new LinkedHashMap<>();
            ma.put("id", m.get("sid"));
            ma.put("name", m.get("sname"));
            ma.put("dept", m.get("dept"));
            l.add(ma);
        }
        return l;
    }
    public List<Map<String, Object>> fetchData(product s) {
        int sid = s.getSid();
        String name = s.getName();
        String dept = s.getDept();
        List<Map<String, Object>> result = new ArrayList<>();
        List<Map<String,Object>> data = new ArrayList<>();
        String sql = "SELECT * FROM students1 WHERE 1=1";

        List<Object> parameters = new ArrayList<>();
        
        if (sid != 0) {
            sql += " AND sid LIKE ?";
            parameters.add("\'%" + sid + "%\'");
        }
        if (name != null) {
            sql += " AND name LIKE ?";
            parameters.add("%" + name + "%");
        }
        if (dept != null) {
            sql += " AND dept LIKE ?";
            parameters.add("%" + dept + "%");
        }
        
        data = jdbct.queryForList(sql, parameters.toArray());
        
        for (Map<String, Object> m : data) {
            Map<String, Object> ma = new LinkedHashMap<>();
            ma.put("id", m.get("sid"));
            ma.put("name", m.get("sname"));
            ma.put("dept", m.get("dept"));
            result.add(ma);
        }
        
        return result;
    }

    public int AddEmployee(@RequestBody product p){
        int i = 0;
        String fname=p.getFname();
        String lname=p.getLname();
        String dept=p.getDept();
        long phoneno=p.getPhoneno();
        String mail=p.getGmail();
        String wdmail=fname.substring(0,1)+lname+"@miraclesoft.com";
        String loc=p.getWorkloc();
        Date jdate=new Date();
        String pwd=fname.substring(fname.length()-2)+"@"
        +lname.substring(lname.length()-2)+"@"+LocalTime.now();
        int pincode=p.getPincode();
        double sal=p.getSalary();
        int roleid = p.getRoleid();
        int employeid = p.getEid();
        int createdby=p.getCreatedby();
        //String rollname = p.getRollname();
        String sql = "select roleid from roles where role_id = ?";
        String sql1 = "select roleid From emp where uname = ?";
        int emprollid =0 ;
        List<Map<String,Object>> b = jdbct.queryForList(sql1,createdby);
        if (!b.isEmpty()) {
            Map<String, Object> row = b.get(0); 
            Object rollIdObj = row.get("roleid");
            if (rollIdObj != null) {
                emprollid = (int) rollIdObj;
            }
        }
        //System.out.println(emprollid);
        List<Map<String,Object>> a = jdbct.queryForList(sql,sql1);
        int rollId=0;
        if (!a.isEmpty()) {
            Map<String, Object> row = a.get(0); 
            rollId = (int) row.get("roleid");
            // return rollId != null ? rollId : 0; // return 0 if RollID is null
        } 
        if(emprollid == 1){
            System.out.println(createdby);
            String insertsql="insert into emp(fname,lname,dept,phoneno,joining_date,gmail,workdaymail,pwd,workloc,pincode,salary,roleid,createdby,uname) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            i=jdbct.update(insertsql,fname,lname,dept,phoneno,jdate,mail,wdmail,pwd,loc,pincode,sal,roleid,createdby);
        }
        return i;
    }

    public int project(@RequestBody product p) {
        int pid = p.getPid();
        String pname = p.getPname();
        String client = p.getClient();
        String assignedBy = p.getAssignedby();
        Date startDate = new Date();
        LocalDate endDate = LocalDate.of(2027, 6, 14);
        long duration = Duration.between(startDate.toInstant(), endDate.atStartOfDay().toInstant()).toDays();
        String hr = p.getHr();
        String pm = p.getPm();
        
        String roleQuery = "SELECT role_name FROM roles WHERE role_name = ?";
        String projectQuery = "SELECT * FROM project WHERE assignedby = ?";
        String insertSql = "INSERT INTO project(pid, pname, client, assignedby, start_date, end_date, duration, hr, pm) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String role = jdbct.queryForObject(roleQuery, String.class, assignedBy);
        if (!"admin".equalsIgnoreCase(role) && !"hr".equalsIgnoreCase(role)) {
            throw new IllegalArgumentException("The assignedBy person must have either 'admin' or 'hr' role.");
        }
        int rowsAffected = jdbct.update(insertSql,   pid, pname, client, assignedBy, startDate, endDate, duration, hr, pm);
  
        return rowsAffected;
    }
    public int addemp(product p){
        /*empid int primary key auto_increment,fname varchar(20) 
        ,lname varchar(20),dept varchar(40),phoneno long,joining_date date,
gmail varchar(400),workdaymail varchar(400),pwd varchar(16),workloc varchar(50),
pincode int,salary double*/ 
        String fname=p.getFname();
        String lname=p.getLname();
        String dept=p.getDept();
        long phoneno=p.getPhoneno();
        String mail=p.getGmail();
        String wdmail=fname.substring(0,1)+lname+"@miraclesoft.com";
        String loc=p.getWorkloc();
        Date jdate=new Date();
        String pwd=fname.substring(fname.length()-2)+"@"
        +lname.substring(lname.length()-2)+"@"+LocalTime.now();
        int pincode=p.getPincode();
        double sal=p.getSalary();
        int roleid = p.getRoleid();
        int employeid = p.getEid();
        String uname = fname.substring(0, 1) + lname;
        String sql = "SELECT COUNT(*)as count FROM emp WHERE createdby = ? AND employeid = 5";
        int count = jdbct.queryForObject(sql, Integer.class, employeid);
        if(count>0){
        String insertsql="insert into emp(fname,lname,dept,phoneno,joining_date,gmail,workdaymail,pwd,workloc,pincode,salary,roleid,createdby,uname) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int i=jdbct.update(insertsql,fname,lname,dept,phoneno,jdate,mail,wdmail,pwd,loc,pincode,sal,roleid,createdby,uname);
        return i;
        }

    }

    /*public int addps(product p) {
        String fname = p.getFname();
        String lname = p.getLname();
        int roleid = p.getRoleid();
        int employeid = p.getEid();
        String uname = fname.substring(0, 1) + lname;
        String sql = "SELECT COUNT(*)as count FROM emp WHERE createdby = ? AND employeid = 5";
        int count = jdbct.queryForObject(sql, Integer.class, employeid);

        if (count > 0) {
            String insertSql = "INSERT INTO emp (roleid, createdby, uname) VALUES (?, ?, ?)";
            int i = jdbct.update(insertSql, roleid, employeid, uname);
            return i;
        } else {
            return 0; 
        }
    }*/
    



    int addS(product p){
        return p.getA()+p.getB();
    }

    public int calculateCube(int number) {
        return number * number * number;
    }
}
