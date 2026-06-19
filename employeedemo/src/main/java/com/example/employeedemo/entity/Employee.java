package com.example.employeedemo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private int employeeId;

    private String employeeName;

    private String department;

    private double salary;

    @Temporal(TemporalType.DATE)
    private Date joiningDate;

    // Default Constructor
    public Employee() {
    }

    // Parameterized Constructor
    public Employee(int employeeId, String employeeName,
            String department, double salary,
            Date joiningDate) {

this.employeeId = employeeId;
this.employeeName = employeeName;
this.department = department;
this.salary = salary;
this.joiningDate = joiningDate;
}
    // Getters and Setters

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }
}