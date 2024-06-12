package com.dauphine.blogger_box_backend_2.Controller;
/*
import com.dauphine.blogger_box_backend_2.DTO.PostCreateDTO;
import com.dauphine.blogger_box_backend_2.DTO.PostUpdateDTO;
import com.dauphine.blogger_box_backend_2.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
@Tag(name = "Post API", description = "Endpoints for managing posts")
public class PostController {

    @GetMapping
    @Operation(summary = "get all posts ordered by creation date", description = "Retourne une liste de tous les postes rangés par date de création")
    public List<Post> getByCreationDate() {}

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Retrieve all posts per a category", description = "Retourne une liste de post appartenant à la catégorie")
    public List<Post> GetByCategory(@PathVariable Long categoryId) {}

    @PostMapping
    @Operation(summary = "Create a new post", description = "Créer un nouveau post")
    public Post createPost(@RequestBody PostCreateDTO postCreateDTO) {}

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing post", description = "Mettre à jour le post avec un ID spéifique")
    public Post updatePost(@PathVariable UUID id, @RequestBody PostUpdateDTO postUpdateDTO) {}

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an existing post", description = "Supprimé le post avec un ID spécifique")
    public boolean deletePost(@PathVariable UUID id) {}
}
   */