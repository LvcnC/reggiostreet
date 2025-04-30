package com.project.reggioStreet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.reggioStreet.model.Product;
import com.project.reggioStreet.service.ProductService;

// controller talks with the OUTSIDE
@RestController
@CrossOrigin // to allow the frontend port to run
// @RequestMapping("/api") // to add to every url int this page, /api/...
public class ProductController {

    /* WE MUST CONNECT frontend and backend */
    // we run into this issue

    // Bloccata richiesta multiorigine (cross-origin): 
     // il criterio di corrispondenza dell’origine non consente la lettura della risorsa remota da 
     // http://localhost:8080/api/products. 
      // Motivo: header CORS “Access-Control-Allow-Origin” mancante. Codice di stato: 200.

    /* CORS ERROR */
    // There can only ONE PORT RUNNING, yet two are!
    // frontend: 7153
    // backend: 8080
    // how do we fix this? thanks to SB we only have to add an annotation
    // @CrossOrigin

    @Autowired
    private Product prod;

    public ProductController(){

    }

    // productservice does BUSINESS LOGIC
    @Autowired
    public ProductService service;
    
    // takes the businessd logiced and spit it out 
    @RequestMapping("/products") // at this address
    public List<Product> getProducts(){
        return service.getProducts();
        // here the JACKSON LIBRARY is CONVERTING your objects, product, into JSON 
    }

    // i only want to see this specific product
    @RequestMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        // so we insert a PLACEHOLDER {id} ->
        // which MUST refer/BOUND to the PARAMETER of the function
        // -> @PathVariable 
        // method parameter <-> URI template variable
    
        prod = service.getProductById(id);

        if(prod != null)
            return new ResponseEntity<>(prod, HttpStatus.OK);
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // same URL, but different HHTTP method(POST!)
    // this controller will handle the REQUEST TO POST something(the object)
    // it will receive the JSON OBJECT and CONVERT IT TO a JAVA OBJECT
    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        // requestBody makes sure that we're receiving the actual JSON OBJECT CONVERTED to JAVA
        service.addProduct(product);
    }

    // i dont want a random object, i want one from the CLIENT SIDE!
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product){
        service.updateProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
    }

    // REMEMBER: Spring can get CONFUSED in mappings like this
    // /products/{id}
    // /products/{name} 
    // even though they are of diffent types, id and name, it still gets confused
    @RequestMapping("/{name}")
    public List<Product> getProductsByName(@PathVariable String name){
        return service.getProductsByName(name);
    }

    @RequestMapping("/products/quantity/{qt}")
    public List<Product> findProductQuantity(@PathVariable("qt") int wantedQt)
    {
        return service.findProductQuantity(wantedQt);
    }

    // To let the frontend know more, other than sending the OBJECT, we can also send the HTTP STATUS
    // even a personalized one! 
    // so it's: OBJECT + HTTP STATUS
    // Concretetly we do that by SENDING a RESPONSE ENTITY (OBJECT + HTTP STATUS)
    @RequestMapping("products/status/{statusProduct}")
    public ResponseEntity<List<Product>> availableProducts(@PathVariable("statusProduct") String status){
        // So we need to return an Object (a new one i guess) of the ResponseEntity
        // OBJECT + HTTP STATUS
        return new ResponseEntity<>(service.availableProducts(status), HttpStatus.OK);
    }

}
