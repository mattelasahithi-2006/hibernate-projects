package com.example.bookdemo.main;

import java.util.Scanner;

import com.example.bookdemo.dao.BookDAO;
import com.example.bookdemo.entity.Book;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        int choice;

        do {
            System.out.println("\n===== BOOK CRUD OPERATIONS =====");
            System.out.println("1. Insert Book");
            System.out.println("2. Retrieve Book");
            System.out.println("3. Update Book Price");
            System.out.println("4. Display All Books");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Available Copies: ");
                    int copies = sc.nextInt();

                    dao.saveBook(new Book(id, title, author, category, price, copies));
                    break;

                case 2:
                    System.out.print("Enter Book ID: ");
                    Book b = dao.getBook(sc.nextInt());

                    if (b != null)
                        System.out.println(b.getTitle() + " " + b.getAuthor());
                    else
                        System.out.println("Book not found.");
                    break;

                case 3:
                    System.out.print("Book ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("New Price: ");
                    double newPrice = sc.nextDouble();

                    dao.updateBook(updateId, newPrice);
                    break;

                case 4:
                    dao.displayAllBooks();
                    break;

                case 5:
                    System.out.print("Book ID to delete: ");
                    dao.deleteBook(sc.nextInt());
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