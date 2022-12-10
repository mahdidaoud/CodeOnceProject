package test.codeonce.ms.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.codeonce.ms.dao.CategoryRepository;
import test.codeonce.ms.dao.ProductRepository;
import test.codeonce.ms.entities.Category;
import test.codeonce.ms.entities.Product;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryrepository;

    @Autowired
    private ProductRepository productrepository;

    @Override
    public Category AddCategory(Category cat) {
        Category c = new Category(null, cat.getName());
        return categoryrepository.save(c);
    }


    @Override
    public List<Category> GetAllCategory() {
        return categoryrepository.findAll();
    }

  

    @Override
    public Category GetCategory(String id) {
        return categoryrepository.findById(id).get();

    }

    @Override
    public void DeleteCategory(String id) {
        Category c=categoryrepository.findById(id).get();
        for(Product p : c.getProducts()){
         productrepository.deleteById(p.getId());   
        }
        categoryrepository.deleteById(id);
    }

}
