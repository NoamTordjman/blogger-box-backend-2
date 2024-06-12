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
    public List<Post> getByCreationDate();
    public List<Post> GetByCategory(@PathVariable Long categoryId);
    public Post createPost(@RequestBody PostCreateDTO postCreateDTO);
    public Post updatePost(@PathVariable UUID id, @RequestBody PostUpdateDTO postUpdateDTO);
    public boolean deletePost(@PathVariable UUID id);
}
