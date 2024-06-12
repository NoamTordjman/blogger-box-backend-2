package com.dauphine.blogger_box_backend_2.Repository;

import com.dauphine.blogger_box_backend_2.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

    List<Post> findAllByCategoryId(UUID categoryId);
}
