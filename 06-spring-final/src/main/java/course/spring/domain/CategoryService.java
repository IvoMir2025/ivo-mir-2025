package course.spring.domain;

import course.spring.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategorys();
    Category getCategoryById(Long id);
    Category getCategoryByCategoryname(String Categoryname);
    Category addCategory(Category Category);
    Category updateCategory(Category Category);
    Category deleteCategoryById(Long id);
    long getCategorysCount();
}
