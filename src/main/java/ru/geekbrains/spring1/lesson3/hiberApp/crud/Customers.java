package ru.geekbrains.spring1.lesson3.hiberApp.crud;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "products_buyers",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Products> products;

    public Customers(){

    }

    public List<Products> getProducts() {
        return products;
    }


    public Customers(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Customer [id = %d, name = %s]", id, name);
    }
}
