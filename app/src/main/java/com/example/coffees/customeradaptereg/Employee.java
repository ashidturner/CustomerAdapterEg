package com.example.coffees.customeradaptereg;

/**
 * Created by Coffees on 1/10/2018.
 */

public class Employee {
    private int lEno;
    private String lEname,lEsalary;

    public Employee(int lEno, String lEname, String lEsalary) {
        this.lEno = lEno;
        this.lEname = lEname;
        this.lEsalary = lEsalary;
    }

    public int getlEno() {
        return lEno;
    }

    public void setlEno(int lEno) {
        this.lEno = lEno;
    }

    public String getlEname() {
        return lEname;
    }

    public void setlEname(String lEname) {
        this.lEname = lEname;
    }

    public String getlEsalary() {
        return lEsalary;
    }

    public void setlEsalary(String lEsalary) {
        this.lEsalary = lEsalary;
    }
}
