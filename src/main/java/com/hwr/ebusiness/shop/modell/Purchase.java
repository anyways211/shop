package com.hwr.ebusiness.shop.modell;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long purchaseId;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customer;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "purchases")
    private List<Product> products;

    public Purchase() {
    }

    public Purchase(String date, Customer customer, List<Product> products) {
        this.date = date;
        this.customer = customer;
        this.products = products;
    }

    public long getId() {
        return purchaseId;
    }

    public void setId(long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
