package com.example.studentdemo.main;

import java.util.List;
import java.util.Scanner;

import com.example.studentdemo.dao.StudentDAO;
import com.example.studentdemo.entity.Student;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        int choice;

        do {

            System.out.println("\n===== STUDENT CRUD OPERATIONS =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Retrieve Student");
            System.out.println("3. Update Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();

                System.out.print("Enter Student Name: ");
                String name = sc.next();

                System.out.print("Enter Email: ");
                String email = sc.next();

                System.out.print("Enter Course: ");
                String course = sc.next();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                Student s = new Student(id, name, email, course, age);
                dao.saveStudent(s);

                break;

            case 2:

                System.out.print("Enter Student ID: ");
                id = sc.nextInt();

                Student student = dao.getStudentById(id);

                if (student != null) {

                    System.out.println("Student ID : " + student.getStudentId());
                    System.out.println("Student Name : " + student.getStudentName());
                    System.out.println("Email : " + student.getEmail());
                    System.out.println("Course : " + student.getCourse());
                    System.out.println("Age : " + student.getAge());

                } else {

                    System.out.println("Student not found.");
                }

                break;

            case 3:

                System.out.print("Enter Student ID to update: ");
                id = sc.nextInt();

                Student st = dao.getStudentById(id);

                if (st != null) {

                    System.out.print("Enter New Name: ");
                    name = sc.next();

                    System.out.print("Enter New Email: ");
                    email = sc.next();

                    System.out.print("Enter New Course: ");
                    course = sc.next();

                    System.out.print("Enter New Age: ");
                    age = sc.nextInt();

                    st.setStudentName(name);
                    st.setEmail(email);
                    st.setCourse(course);
                    st.setAge(age);

                    dao.updateStudent(st);

                } else {

                    System.out.println("Student not found.");
                }

                break;

            case 4:

                List<Student> students = dao.getAllStudents();

                System.out.println("\nID\tNAME\tEMAIL\tCOURSE\tAGE");

                for (Student stu : students) {

                    System.out.println(
                            stu.getStudentId() + "\t"
                                    + stu.getStudentName() + "\t"
                                    + stu.getEmail() + "\t"
                                    + stu.getCourse() + "\t"
                                    + stu.getAge());
                }

                break;

            case 5:

                System.out.print("Enter Student ID to delete: ");
                id = sc.nextInt();

                dao.deleteStudent(id);

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