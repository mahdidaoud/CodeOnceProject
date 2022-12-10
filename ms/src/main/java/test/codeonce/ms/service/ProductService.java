package test.codeonce.ms.service;

import java.util.List;

import test.codeonce.ms.dto.CategoryDto;
import test.codeonce.ms.dto.ProductDto;
import test.codeonce.ms.entities.Product;

public interface ProductService {
    Product AddProduct(ProductDto prod);

    List<Product> GetAllProduct();

    Product GetProduct(String id);

    void DeleteProduct(String id);

    List<Product> ProdDispo(CategoryDto cat);

}
