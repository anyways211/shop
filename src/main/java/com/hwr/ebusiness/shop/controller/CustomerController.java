package com.hwr.ebusiness.shop.controller;

import com.hwr.ebusiness.shop.modell.Customer;
import com.hwr.ebusiness.shop.modell.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//händelt alle Abfragen unter den URL's /customer...
@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/customers")
    public ResponseEntity<List<Customer>> ShowAllCustomers(){
        //alle Customer suchen
        List<Customer> customers = customerRepository.findAll();
        //Liste ausgeben
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("/customer/{id}")
    @ResponseBody
    public ResponseEntity<Customer> ShowOneCustomer(@PathVariable("id") Long id) {
        //customer nach suchen
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            //customer gefunden
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        }
        else {
            //kein customer mit id gefunden
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/customer/{id}")
    @ResponseBody
    public ResponseEntity<Customer> DeleteOneCustomer(@PathVariable("id") Long id) {
        //customer suchen
        Optional<Customer> customer = customerRepository.findById(id);
        //wenn gefunden
        if(customer.isPresent()) {
            try {
                //löschen
                customerRepository.deleteById(id);
                //positive Rückmeldung
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                //fehler beim löschen
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            //kein customer mit gesuchter ID gefunden
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
