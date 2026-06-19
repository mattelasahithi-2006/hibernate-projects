package com.example.employeedemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.employeedemo.entity.Employee;
import com.example.employeedemo.util.HibernateUtil;

public class EmployeeDAO {

    // Insert Employee
    public void saveEmployee(Employee employee) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(employee);

        tx.commit();
        session.close();

        System.out.println("Employee inserted successfully.");
    }

    // Retrieve Employee by ID
    public Employee getEmployeeById(int employeeId) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Employee employee = session.get(Employee.class, employeeId);

        session.close();

        return employee;
    }

    // Update Employee
    public void updateEmployee(Employee employee) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(employee);

        tx.commit();
        session.close();

        System.out.println("Employee updated successfully.");
    }

    // Delete Employee
    public void deleteEmployee(int employeeId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee employee = session.get(Employee.class, employeeId);

        if (employee != null) {
            session.delete(employee);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }

        tx.commit();
        session.close();
    }

    // Display All Employees
    public List<Employee> getAllEmployees() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Employee> employees =
                session.createQuery("from Employee", Employee.class).list();

        session.close();

        return employees;
    }
}