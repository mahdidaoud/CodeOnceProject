package test.codeonce.ms.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import test.codeonce.ms.entities.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
    List<Category> findByName(String name);
}
