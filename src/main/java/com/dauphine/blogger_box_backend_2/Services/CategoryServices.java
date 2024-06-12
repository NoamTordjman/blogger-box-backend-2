package com.dauphine.blogger_box_backend_2.Services;

import com.dauphine.blogger_box_backend_2.Category;
import com.dauphine.blogger_box_backend_2.DTO.CategoryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface CategoryServices {

     List<Category> getAllCategories();
    public Category getCategoryById(@PathVariable UUID id);
    public Category createCategory(@RequestBody String name);
    public Category updateCategoryName(UUID id, CategoryDTO categoryDTO);
    public void deleteCategory(@PathVariable UUID id);


}
