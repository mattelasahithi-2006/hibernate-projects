package com.example.employeedemo.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.example.employeedemo.dao.EmployeeDAO;
import com.example.employeedemo.entity.Employee;

public class App {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        int choice;

        do {

            System.out.println("\n===== EMPLOYEE CRUD OPERATIONS =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Retrieve Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();

                System.out.print("Enter Employee Name: ");
                String name = sc.next();

                System.out.print("Enter Department: ");
                String department = sc.next();

                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();

                System.out.print("Enter Joining Date (yyyy-MM-dd): ");
                String date = sc.next();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                Employee emp = new Employee(
                        id,
                        name,
                        department,
                        salary,
                        sdf.parse(date));

                dao.saveEmployee(emp);

                break;

            case 2:

                System.out.print("Enter Employee ID: ");
                id = sc.nextInt();

                Employee employee = dao.getEmployeeById(id);

                if (employee != null) {

                    System.out.println("Employee ID : " + employee.getEmployeeId());
                    System.out.println("Employee Name : " + employee.getEmployeeName());
                    System.out.println("Department : " + employee.getDepartment());
                    System.out.println("Salary : " + employee.getSalary());
                    System.out.println("Joining Date : " + employee.getJoiningDate());

                } else {

                    System.out.println("Employee not found.");
                }

                break;

            case 3:

                System.out.print("Enter Employee ID to update: ");
                id = sc.nextInt();

                Employee e = dao.getEmployeeById(id);

                if (e != null) {

                    System.out.print("Enter New Department: ");
                    department = sc.next();

                    System.out.print("Enter New Salary: ");
                    salary = sc.nextDouble();

                    e.setDepartment(department);
                    e.setSalary(salary);

                    dao.updateEmployee(e);

                } else {

                    System.out.println("Employee not found.");
                }

                break;

            case 4:

                List<Employee> employees = dao.getAllEmployees();

                System.out.println("\nID\tNAME\tDEPARTMENT\tSALARY");

                for (Employee emp1 : employees) {

                    System.out.println(
                            emp1.getEmployeeId() + "\t"
                                    + emp1.getEmployeeName() + "\t"
                                    + emp1.getDepartment() + "\t"
                                    + emp1.getSalary());
                }

                break;

            case 5:

                System.out.print("Enter Employee ID to delete: ");
                id = sc.nextInt();

                dao.deleteEmployee(id);

                break;

            case 6:

                System.out.println("Exiting...");
                break;

            default:

                System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}