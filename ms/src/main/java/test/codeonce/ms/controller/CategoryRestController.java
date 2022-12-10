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

import test.codeonce.ms.entities.Category;
import test.codeonce.ms.service.CategoryService;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryservice;

    @PostMapping("/AddCategory")
    public ResponseEntity<Category> AddCat(@RequestBody Category cat) {
        return new ResponseEntity<>(categoryservice.AddCategory(cat), HttpStatus.CREATED);
    }

    @GetMapping(value = "/Categories")
    public ResponseEntity<List<Category>> getAllCat() {
        return ResponseEntity.ok(categoryservice.GetAllCategory());
    }

    @GetMapping(value = "/Category/{id}")
    public ResponseEntity<Category> getCat(@PathVariable String id) {
        return ResponseEntity.ok(categoryservice.GetCategory(id));

    }

    @DeleteMapping(value = "/DeleteCategory/{id}")
    public ResponseEntity<Category> DelCat(@PathVariable String id) {
        categoryservice.DeleteCategory(id);
        return new ResponseEntity<Category>(HttpStatus.OK);
    }

}
