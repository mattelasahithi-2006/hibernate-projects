package com.example.orderdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.orderdemo.entity.Order;
import com.example.orderdemo.util.HibernateUtil;

public class OrderDAO {

    // Insert
    public void saveOrder(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(order);

        tx.commit();
        session.close();

        System.out.println("Order inserted successfully.");
    }

    // Retrieve
    public Order getOrder(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Order order = session.get(Order.class, id);

        session.close();
        return order;
    }

    // Update Order Status
    public void updateOrderStatus(int id, String status) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Order order = session.get(Order.class, id);

        if (order != null) {
            order.setOrderStatus(status);
            session.merge(order);
            System.out.println("Order updated successfully.");
        } else {
            System.out.println("Order not found.");
        }

        tx.commit();
        session.close();
    }

    // Display All Orders
    public void displayAllOrders() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Order> orders = session.createQuery("from Order", Order.class).list();

        for (Order order : orders) {
            System.out.println(order);
        }

        session.close();
    }

    // Delete
    public void deleteOrder(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Order order = session.get(Order.class, id);

        if (order != null) {
            session.remove(order);
            System.out.println("Order deleted successfully.");
        } else {
            System.out.println("Order not found.");
        }

        tx.commit();
        session.close();
    }
}