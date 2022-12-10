package test.codeonce.ms.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import test.codeonce.ms.entities.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}