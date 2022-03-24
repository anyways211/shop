package com.hwr.ebusiness.shop.modell;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long CustomerId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "street")
    private String street;

    @Column(name = "zipcode")
    private int zipcode;

    @Column(name = "town")
    private String town;

    @Column(name = "house")
    private int house;

 /*   @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private List<Purchase> purchases;*/

    public Customer() {
    }

    public Customer(String firstname, String lastname, String street, int zipcode, String town, int house) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.zipcode = zipcode;
        this.town = town;
        this.house = house;
    }

    public long getId() {
        return CustomerId;
    }

    public void setId(long CustomerId) {
        this.CustomerId = CustomerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

  /*  public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }*/

    @Override
    public String toString() {
        return "Kunde [id="+this.getId()+", vorname="+this.getFirstname()+", Nachname="
                +this.lastname+", Straße="+this.street+", Nr.="+this.getHouse()+", PLZ="+this.zipcode
                +", Ort="+this.town+"]";
    }
}
