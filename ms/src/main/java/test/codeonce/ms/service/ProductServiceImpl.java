package test.codeonce.ms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.codeonce.ms.dto.ProductDto;
import test.codeonce.ms.dao.CategoryRepository;
import test.codeonce.ms.dao.ProductRepository;
import test.codeonce.ms.dto.CategoryDto;
import test.codeonce.ms.entities.Category;
import test.codeonce.ms.entities.Product;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productrepository;

    @Autowired
    private CategoryRepository categoryrepository;

    @Override
    public Product AddProduct(ProductDto prod) {
        List<Category> L = categoryrepository.findByName(prod.getCategoryname());
        if (L.size() == 0)
            return null;
        Category cat = L.get(0);
        Product p = productrepository.save(new Product(null, prod.getName(), prod.getQuantity(), cat));
        cat.getProducts().add(p);
        categoryrepository.save(cat);
        return p;

    }
    @Override
    public List<Product> GetAllProduct() {
        return productrepository.findAll();
    }
    @Override
    public Product GetProduct(String id) {
        return productrepository.findById(id).get();

    }
    @Override
    public void DeleteProduct(String id) {
        productrepository.deleteById(id);

    }
    @Override
    public List<Product> ProdDispo(CategoryDto cat) {
        List<Product> Res = new ArrayList<Product>();
        List<Category> L = categoryrepository.findByName(cat.getCategoryname());
        System.out.println("cata" + L);
        Category cata = L.get(0);

        for (Product p : cata.getProducts()) {
            if (p.getQuantity() > 0) {

                Product pdto = new Product(p.getId(),p.getName(), p.getQuantity(), p.getCategory());
                Res.add(pdto);
            }
        }
        return Res;

    }
  

}
