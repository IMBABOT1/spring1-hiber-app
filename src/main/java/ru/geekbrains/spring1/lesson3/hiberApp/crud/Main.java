package ru.geekbrains.spring1.lesson3.hiberApp.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.spring1.lesson3.hiberApp.PrepareDataApp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PrepareDataApp.forcePrepareData();

        Long maxId = null;

        SessionFactory factory = new Configuration()
                .configure("config/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;




        System.out.println("Press: '/customer' to inspect products that client buy");
        System.out.println("Press: '/product' to inspect customers that buy certain product");
        System.out.println("Press: '/break' to exit");
        System.out.println("Press: '/dell_customer' to delete customer");
        System.out.println("Press: '/dell_product' to delete customer");

        session = factory.getCurrentSession();
        session.beginTransaction();


        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        try {
            if (name.equals("/customer")){
                while (true) {
                    Scanner customerId = new Scanner(System.in);
                    System.out.println("Press customer id to watch products that client buy");
                    System.out.println("Press /break to exit");
                    String clientId = customerId.nextLine();

                    if (clientId.equals("/break")){
                        break;
                    }else {
                        Customers customer = session.get(Customers.class, Long.parseLong(clientId));
                        System.out.println(customer + "\n" + "buy");
                        System.out.println(customer.getProducts());
                    }
                }
            }else if (name.equals("/product")){
                while (true) {
                    Scanner customerId = new Scanner(System.in);
                    System.out.println("Press product id to watch customers that buy product");
                    System.out.println("Press /break to exit");

                    String productId = customerId.nextLine();

                    if (productId.equals("/break")) {
                        break;
                    } else {
                        Products product = session.get(Products.class, Long.parseLong(productId));
                        System.out.println(product + "\n" + "buy");
                        System.out.println(product.getCustomers());
                    }
                }  } else if (name.equals("/dell_customer")) {
                while (true) {
                    System.out.println("Press customer_id to delete customer");
                    System.out.println("/break to exit");
                    Scanner scanner1 = new Scanner(System.in);
                    String customerId = scanner1.nextLine();
                    if (customerId.equals("/break")){
                        break;
                    }else {
                        Customers customer = session.get(Customers.class, Long.parseLong(customerId));
                        session.delete(customer);
                    }
                }
            }else if (name.equals("/dell_product")){
                while (true) {
                    System.out.println("Press product_id to delete product");
                    System.out.println("/break to exit");
                    Scanner scanner1 = new Scanner(System.in);
                    String productId = scanner1.nextLine();
                    if (productId.equals("/break")){
                        break;
                    }else {
                        Products product = session.get(Products.class, Long.parseLong(productId));
                        session.delete(product);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
