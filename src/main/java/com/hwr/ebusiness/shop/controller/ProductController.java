package com.hwr.ebusiness.shop.controller;

import com.hwr.ebusiness.shop.modell.Product;
import com.hwr.ebusiness.shop.modell.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//händelt Abfragen unter /product...
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    //alle Produkte anzeigen
    @RequestMapping(method = RequestMethod.GET, path = "/products")
    public ResponseEntity<List<Product>> ShowAllCustomers(){
        //Produkte aus DB auflisten
        List<Product> products = productRepository.findAll();
        //Liste ausgeben
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    //ein Produkt nach ID anzeigen
    @GetMapping("/product/{id}")
    @ResponseBody
    public ResponseEntity<Product> ShowOneCustomers(@PathVariable Long id) {
        //produkt nach id suchen
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            //gefundenes Produkt ausgeben
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        else {
            //nicht gefunden -> fehler ausgeben
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/product/{id}")
    @ResponseBody
    public ResponseEntity<Product> DeleteOneProduct(@PathVariable("id") Long id) {
        //objekt suchen
        Optional<Product> product = productRepository.findById(id);
        //wenn objekt gefunden
        if(product.isPresent()) {
            try {
                //löschen und positive Rückmeldung
                productRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                //fehler beim Löschen
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }else{
            //produkt mit gesuchter ID nicht gefunden
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //neues Produkt anlegen
    @PostMapping(path="/product",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Product> postProduct(@RequestBody Product product){
        //nach Produkt suchen
        Optional<Product> newProduct = productRepository.findById(product.getId());
        if (newProduct.isPresent()) {
            //bei Post soll nichts geändert werden, also fehler, wenn es das Produkt schon gibt
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            //neues Produkt anlegen
            productRepository.save(product);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }
    }

    //neues Produkt anlegen oder überschreiben
    @PutMapping(path="/product",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Product> putProduct(@RequestBody Product product){
        //neues Produkt anlegen oder altes überschreiben/ändern
        Product newProduct = productRepository.save(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);

    }
}
