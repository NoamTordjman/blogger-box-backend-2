package com.dauphine.blogger_box_backend_2.Controller;


import java.util.List;
import java.util.UUID;

import com.dauphine.blogger_box_backend_2.Category;
import com.dauphine.blogger_box_backend_2.DTO.CategoryDTO;
import com.dauphine.blogger_box_backend_2.Services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/categories")
@Tag(name = "Category API", description = "Classe permettant de gerer les catégories")
public class CategoryController {

    private final CategoryServices categoryServices;

    @Autowired
    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @GetMapping
    @Operation(summary = "Retrieve all categories", description = "Retourne une liste de catégories")
    public List<Category> getAllCategories() {
        return categoryServices.getAllCategories();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve a category by id", description = "Retourne la catégorie avec l'id spécifique")
    public Category getCategoryById(@PathVariable UUID id){
        return categoryServices.getCategoryById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new category", description = "Crée une nouvelle catégorie")
    public Category createCategory(@RequestBody String name) throws Exception {
        return categoryServices.createCategory(name);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update the name of a category", description = "met à jour le nom d'une catégorie avec l'id spécifié")
    public Category updateCategoryName(@PathVariable UUID id, CategoryDTO categoryDTO) throws Exception{
        return categoryServices.updateCategoryName(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an existing category", description = "Supprime un compte avec son id")
    public void deleteCategory(@PathVariable UUID id) {
        categoryServices.deleteCategory(id);
    };


}



