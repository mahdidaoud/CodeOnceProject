
package test.codeonce.ms.service;


import java.util.List;


import test.codeonce.ms.entities.Category;

public interface CategoryService {
    Category AddCategory(Category cat);

    List<Category> GetAllCategory();
    
    Category GetCategory(String id);

    void DeleteCategory(String id);

}
