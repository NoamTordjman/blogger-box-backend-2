package com.dauphine.blogger_box_backend_2.Services;

import com.dauphine.blogger_box_backend_2.DTO.PostCreateDTO;
import com.dauphine.blogger_box_backend_2.DTO.PostUpdateDTO;
import com.dauphine.blogger_box_backend_2.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


public interface PostServices {
    public List<Post> getAll();
    public List<Post> GetByCategory(@PathVariable UUID categoryId);
    public Post createPost(@PathVariable UUID categoryId, @RequestBody PostCreateDTO postCreateDTO);
    public Post updatePost(@PathVariable UUID id, @RequestBody PostUpdateDTO postUpdateDTO, @PathVariable UUID CategoryId);
    public void deletePost(@PathVariable UUID id);
}
