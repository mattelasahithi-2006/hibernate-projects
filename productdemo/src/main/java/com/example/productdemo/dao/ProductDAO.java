package com.example.productdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.productdemo.entity.Product;
import com.example.productdemo.util.HibernateUtil;

public class ProductDAO {

    // Insert Product
    public void saveProduct(Product product) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(product);

        tx.commit();
        session.close();

        System.out.println("Product inserted successfully.");
    }

    // Get Product by ID
    public Product getProductById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Product product = session.get(Product.class, id);

        session.close();

        return product;
    }

    // Update Product
    public void updateProduct(Product product) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(product);

        tx.commit();
        session.close();

        System.out.println("Product updated successfully.");
    }

    // Delete Product
    public void deleteProduct(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product product = session.get(Product.class, id);

        if (product != null) {
            session.delete(product);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }

        tx.commit();
        session.close();
    }

    // Display All Products
    public List<Product> getAllProducts() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Product> products =
                session.createQuery("from Product", Product.class).list();

        session.close();

        return products;
    }
}