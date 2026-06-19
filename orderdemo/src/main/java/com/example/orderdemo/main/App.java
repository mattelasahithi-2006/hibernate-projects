package com.example.orderdemo.main;



import java.time.LocalDate;
import java.util.Scanner;

import com.example.orderdemo.dao.OrderDAO;
import com.example.orderdemo.entity.Order;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OrderDAO dao = new OrderDAO();

        int choice;

        do {

            System.out.println("\n===== ORDER CRUD OPERATIONS =====");
            System.out.println("1. Insert Order");
            System.out.println("2. Retrieve Order");
            System.out.println("3. Update Order Status");
            System.out.println("4. Display All Orders");
            System.out.println("5. Delete Order");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Order ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Customer Name: ");
                    String customerName = sc.nextLine();

                    System.out.print("Food Item: ");
                    String foodItem = sc.nextLine();

                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();

                    System.out.print("Total Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Order Status: ");
                    String status = sc.nextLine();

                    Order order = new Order(
                            id,
                            customerName,
                            foodItem,
                            quantity,
                            amount,
                            LocalDate.now(),
                            status);

                    dao.saveOrder(order);
                    break;

                case 2:

                    System.out.print("Enter Order ID: ");
                    Order o = dao.getOrder(sc.nextInt());

                    if (o != null)
                        System.out.println(o);
                    else
                        System.out.println("Order not found.");

                    break;

                case 3:

                    System.out.print("Enter Order ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Status: ");
                    String newStatus = sc.nextLine();

                    dao.updateOrderStatus(updateId, newStatus);

                    break;

                case 4:
                    dao.displayAllOrders();
                    break;

                case 5:

                    System.out.print("Enter Order ID to delete: ");
                    dao.deleteOrder(sc.nextInt());

                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}