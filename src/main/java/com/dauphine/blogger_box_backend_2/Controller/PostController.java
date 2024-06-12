package com.dauphine.blogger_box_backend_2.Controller;

import com.dauphine.blogger_box_backend_2.DTO.PostCreateDTO;
import com.dauphine.blogger_box_backend_2.DTO.PostUpdateDTO;
import com.dauphine.blogger_box_backend_2.Post;
import com.dauphine.blogger_box_backend_2.Services.PostServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
@Tag(name = "Post API", description = "Endpoints for managing posts")
public class PostController {

    private final PostServices postServices;

    @Autowired
    public PostController(PostServices postServices) {
        this.postServices = postServices;
    }


    @GetMapping
    @Operation(summary = "get all posts", description = "Retourne une liste de tous les postes")
    public List<Post> getAll() {
        return postServices.getAll();
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Retrieve all posts per a category", description = "Retourne une liste de post appartenant à la catégorie")
    public List<Post> GetByCategory(@PathVariable UUID categoryId) throws ChangeSetPersister.NotFoundException {
        return postServices.GetByCategory(categoryId);
    }

    @PostMapping
    @Operation(summary = "Create a new post", description = "Créer un nouveau post")
    public Post createPost(@RequestBody PostCreateDTO postCreateDTO, @PathVariable UUID categoryId) throws ChangeSetPersister.NotFoundException {
        return postServices.createPost(categoryId, postCreateDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing post", description = "Mettre à jour le post avec un ID spéifique")
    public Post updatePost(@PathVariable UUID id, @RequestBody PostUpdateDTO postUpdateDTO, @PathVariable UUID categoryId) throws ChangeSetPersister.NotFoundException {
        return postServices.updatePost(id, postUpdateDTO, categoryId);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an existing post", description = "Supprimé le post avec un ID spécifique")
    public void deletePost(@PathVariable UUID id) {}
}
