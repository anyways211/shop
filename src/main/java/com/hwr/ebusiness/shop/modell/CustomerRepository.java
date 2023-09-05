package com.hwr.ebusiness.shop.modell;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//Repository zum händeln von Anfragen auf Entität Customer
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    void deleteById(Long id);
}
