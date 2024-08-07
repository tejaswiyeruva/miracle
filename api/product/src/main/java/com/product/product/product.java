package com.product.product;

public class product {
    private int pid;
    private String pname;
    public int getTrip_id() {
        return trip_id;
    }
    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }
    private float price;
    private int trip_id;
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    private int sid;
    private String name;
    private String dept;
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }


    /*empid int primary key auto_increment,fname varchar(20) 
        ,lname varchar(20),dept varchar(40),phoneno long,joining_date date,
gmail varchar(400),workdaymail varchar(400),pwd varchar(16),workloc varchar(50),
pincode int,salary double*/ 
private int roleid;
private int createdby;
public int getRoleid() {
    return roleid;
}
public void setRoleid(int roleid) {
    this.roleid = roleid;
}
public int getCreatedby() {
    return createdby;
}
public void setCreatedby(int createdby) {
    this.createdby = createdby;
}
private int eid;
private String fname;
private String lname;
private long phoneno;
private String gmail;
private String wdmail;
private String pwd;
private int pincode;
private double salary;
private String workloc;
private int a;
private int b;
public int getA() {
    return a;
}
public void setA(int a) {
    this.a = a;
}
public int getB() {
    return b;
}
public void setB(int b) {
    this.b = b;
}
public String getWorkloc() {
    return workloc;
}
public void setWorkloc(String workloc) {
    this.workloc = workloc;
}
public int getEid() {
    return eid;
}
public void setEid(int eid) {
    this.eid = eid;
}
public String getFname() {
    return fname;
}
public void setFname(String fname) {
    this.fname = fname;
}
public String getLname() {
    return lname;
}
public void setLname(String lname) {
    this.lname = lname;
}
public long getPhoneno() {
    return phoneno;
}
public void setPhoneno(long phoneno) {
    this.phoneno = phoneno;
}
public String getGmail() {
    return gmail;
}
public void setGmail(String gmail) {
    this.gmail = gmail;
}
public String getWdmail() {
    return wdmail;
}
public void setWdmail(String wdmail) {
    this.wdmail = wdmail;
}
public String getPwd() {
    return pwd;
}
public void setPwd(String pwd) {
    this.pwd = pwd;
}
public int getPincode() {
    return pincode;
}
public void setPincode(int pincode) {
    this.pincode = pincode;
}
public double getSalary() {
    return salary;
}
public void setSalary(double salary) {
    this.salary = salary;
}
private String client;
private String assignedby;
private String hr;
private String pm;
public String getClient() {
    return client;
}
public void setClient(String client) {
    this.client = client;
}
public String getAssignedby() {
    return assignedby;
}
public void setAssignedby(String assignedby) {
    this.assignedby = assignedby;
}
public String getHr() {
    return hr;
}
public void setHr(String hr) {
    this.hr = hr;
}
public String getPm() {
    return pm;
}
public void setPm(String pm) {
    this.pm = pm;
}
}
