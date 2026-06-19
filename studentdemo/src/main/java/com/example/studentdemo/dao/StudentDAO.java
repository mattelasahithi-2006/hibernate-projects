package com.example.studentdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.studentdemo.entity.Student;
import com.example.studentdemo.util.HibernateUtil;

public class StudentDAO {

    public void saveStudent(Student student) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(student);

        tx.commit();
        session.close();

        System.out.println("Student inserted successfully.");
    }

    public Student getStudentById(int studentId) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Student student = session.get(Student.class, studentId);

        session.close();

        return student;
    }

    public void updateStudent(Student student) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(student);

        tx.commit();
        session.close();

        System.out.println("Student updated successfully.");
    }

    public void deleteStudent(int studentId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, studentId);

        if (student != null) {
            session.delete(student);
            System.out.println("Student deleted successfully.");
        }

        tx.commit();
        session.close();
    }

    public List<Student> getAllStudents() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Student> students =
                session.createQuery("from Student", Student.class).list();

        session.close();

        return students;
    }
}