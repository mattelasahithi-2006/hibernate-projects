package com.example.bookdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.bookdemo.entity.Book;
import com.example.bookdemo.util.HibernateUtil;

public class BookDAO {

    // Insert
    public void saveBook(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(book);

        tx.commit();
        session.close();
        System.out.println("Book inserted successfully.");
    }

    // Retrieve by ID
    public Book getBook(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Book book = session.get(Book.class, id);
        session.close();
        return book;
    }

    // Update
    public void updateBook(int id, double newPrice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Book book = session.get(Book.class, id);

        if (book != null) {
            book.setPrice(newPrice);
            session.merge(book);
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }

        tx.commit();
        session.close();
    }

    // Display All
    public void displayAllBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Book> books = session
                .createQuery("from Book", Book.class)
                .list();

        for (Book b : books) {
            System.out.println(
                    b.getBookId() + " "
                    + b.getTitle() + " "
                    + b.getAuthor() + " "
                    + b.getCategory() + " "
                    + b.getPrice() + " "
                    + b.getAvailableCopies());
        }

        session.close();
    }

    // Delete
    public void deleteBook(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Book book = session.get(Book.class, id);

        if (book != null) {
            session.remove(book);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }

        tx.commit();
        session.close();
    }
}