package com.dauphine.blogger_box_backend_2.Services.Impl;

import com.dauphine.blogger_box_backend_2.Category;
import com.dauphine.blogger_box_backend_2.DTO.CategoryDTO;
import com.dauphine.blogger_box_backend_2.Repository.CategoryRepository;
import com.dauphine.blogger_box_backend_2.Services.CategoryServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServicesImpl implements CategoryServices {

    private final CategoryRepository repository;

    @Autowired
    public CategoryServicesImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Category getCategoryById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
    }

    @Override
    public Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return repository.save(category);
    }

    @Override
    public Category updateCategoryName(UUID id, CategoryDTO categoryDTO) {
        Category category = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
        category.setName(categoryDTO.getName());
        return repository.save(category);
    }

    @Override
    public void deleteCategory(UUID id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Category not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
