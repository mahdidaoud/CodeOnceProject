package test.codeonce.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import test.codeonce.ms.dto.CategoryDto;
import test.codeonce.ms.dto.ProductDto;
import test.codeonce.ms.entities.Product;
import test.codeonce.ms.service.ProductService;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ProductRestController {
    @Autowired
    private ProductService productservice;

    @PostMapping("/AddProduct")
    public ResponseEntity<Product> AddProd(@RequestBody ProductDto prod) {
        return new ResponseEntity<>(productservice.AddProduct(prod), HttpStatus.CREATED);
    }

    @GetMapping(value = "/Products")
    public ResponseEntity<List<Product>> getAllProd() {
        return ResponseEntity.ok(productservice.GetAllProduct());
    }

    @PostMapping(value = "/ProdDispo")
    public ResponseEntity<List<Product>> ProdDispo(@RequestBody CategoryDto cat) {
        return ResponseEntity.ok(productservice.ProdDispo(cat));
    }

    @GetMapping(value = "/Product/{id}")
    public ResponseEntity<Product> getCat(@PathVariable String id) {
        return ResponseEntity.ok(productservice.GetProduct(id));

    }

    @DeleteMapping(value = "/DeleteProd/{id}")
    public ResponseEntity<Product> DelProd(@PathVariable String id) {
        productservice.DeleteProduct(id);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }

}
