package com.dauphine.blogger_box_backend_2.Services.Impl;

import com.dauphine.blogger_box_backend_2.Category;
import com.dauphine.blogger_box_backend_2.DTO.PostCreateDTO;
import com.dauphine.blogger_box_backend_2.DTO.PostUpdateDTO;
import com.dauphine.blogger_box_backend_2.Post;
import com.dauphine.blogger_box_backend_2.Repository.CategoryRepository;
import com.dauphine.blogger_box_backend_2.Repository.PostRepository;
import com.dauphine.blogger_box_backend_2.Services.PostServices;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public class PostServicesImpl implements PostServices {

    private final CategoryRepository CategoryRepository;
    private final PostRepository PostRepository;

    public PostServicesImpl(com.dauphine.blogger_box_backend_2.Repository.CategoryRepository categoryRepository, com.dauphine.blogger_box_backend_2.Repository.PostRepository postRepository) {
        CategoryRepository = categoryRepository;
        PostRepository = postRepository;
    }


    @Override
    public List<Post> getAll() {
        return PostRepository.findAll();
    }

    @Override
    public List<Post> GetByCategory(UUID categoryId) {
        return PostRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public Post createPost(UUID categoryID, PostCreateDTO postCreateDTO) {
        Category category = CategoryRepository.getReferenceById(categoryID);
        Post post = new Post(postCreateDTO.getTitle(), category);
        post.setTitle(postCreateDTO.getTitle());
        return PostRepository.save(post);
    }

    @Override
    public Post updatePost(UUID id, PostUpdateDTO postUpdateDTO, UUID categoryId) {
        Category category = CategoryRepository.getReferenceById(categoryId);
        Post post = PostRepository.getReferenceById(id);
        post.setTitle(postUpdateDTO.getTitle());
        post.setContent(postUpdateDTO.getContent());
        post.setCategory_id(category);
        return PostRepository.save(post);
    }

    @Override
    public void deletePost(UUID id) {
        PostRepository.deleteById(id);
    }
}
