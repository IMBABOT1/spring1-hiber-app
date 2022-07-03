package ru.geekbrains.spring1.lesson3.hiberApp.crud;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Products {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    @ManyToMany
    @JoinTable(
            name = "products_buyers",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customers> customers;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public List<Customers> getCustomers() {
        return customers;
    }



    public Products(Long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Products(){

    }


    @Override
    public String toString() {
        return String.format("Product [id = %d, title = %s, price = %d]", id, title, price);
    }
}
