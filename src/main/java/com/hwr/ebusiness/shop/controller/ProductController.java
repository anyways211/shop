package com.hwr.ebusiness.shop.controller;

import com.hwr.ebusiness.shop.modell.Product;
import com.hwr.ebusiness.shop.modell.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/products")
    public ResponseEntity<List<Product>> ShowAllCustomers(){
        List<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    @ResponseBody
    public ResponseEntity<Product> ShowOneCustomers(@PathVariable Long id) {
        Optional<Product> customer = productRepository.findById(id);
        if (customer.isPresent()){
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/product/delete/{id}")
    @ResponseBody
    public ResponseEntity<Product> DeleteOneProduct(@PathVariable("id") Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            try {
                productRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
