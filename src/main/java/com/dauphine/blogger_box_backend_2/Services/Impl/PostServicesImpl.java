package com.dauphine.blogger_box_backend_2.Services.Impl;

import com.dauphine.blogger_box_backend_2.Category;
import com.dauphine.blogger_box_backend_2.DTO.PostCreateDTO;
import com.dauphine.blogger_box_backend_2.DTO.PostUpdateDTO;
import com.dauphine.blogger_box_backend_2.Post;
import com.dauphine.blogger_box_backend_2.Repository.CategoryRepository;
import com.dauphine.blogger_box_backend_2.Repository.PostRepository;
import com.dauphine.blogger_box_backend_2.Services.PostServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostServicesImpl implements PostServices {

    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;

    public PostServicesImpl(CategoryRepository categoryRepository, PostRepository postRepository) {
        this.categoryRepository = categoryRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> GetByCategory(UUID categoryId) {
        return postRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public Post createPost(UUID categoryID, PostCreateDTO postCreateDTO) {
        Category category = categoryRepository.findById(categoryID)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + categoryID));
        Post post = new Post(postCreateDTO.getTitle(), category);
        post.setTitle(postCreateDTO.getTitle());
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(UUID id, PostUpdateDTO postUpdateDTO, UUID categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + categoryId));
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + id));
        post.setTitle(postUpdateDTO.getTitle());
        post.setContent(postUpdateDTO.getContent());
        post.setCategory(category);
        return postRepository.save(post);
    }

    @Override
    public void deletePost(UUID id) {
        if (!postRepository.existsById(id)) {
            throw new EntityNotFoundException("Post not found with id: " + id);
        }
        postRepository.deleteById(id);
    }
}
