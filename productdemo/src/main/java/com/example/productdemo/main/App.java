package com.example.productdemo.main;

import java.util.List;

import com.example.productdemo.dao.ProductDAO;
import com.example.productdemo.entity.Product;

public class App {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        // ================= INSERT =================
        Product p = new Product(103, "Laptop", 50000);
        dao.saveProduct(p);

        // ================= GET BY ID =================
        Product product = dao.getProductById(101);

        if (product != null) {
            System.out.println("\nRetrieved Product:");
            System.out.println(product.getId() + " "
                    + product.getName() + " "
                    + product.getPrice());
        }

        // ================= UPDATE =================
        if (product != null) {
            product.setPrice(55000);
            dao.updateProduct(product);
        }

        // ================= DISPLAY ALL =================
        System.out.println("\nAll Products:");

        List<Product> products = dao.getAllProducts();

        for (Product prod : products) {
            System.out.println(prod.getId() + " "
                    + prod.getName() + " "
                    + prod.getPrice());
        }

        // ================= DELETE =================
        dao.deleteProduct(101);

        System.out.println("\nCRUD Operations Completed Successfully.");
    }
}