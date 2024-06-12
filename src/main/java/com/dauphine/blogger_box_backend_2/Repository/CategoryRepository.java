package com.dauphine.blogger_box_backend_2.Repository;

import com.dauphine.blogger_box_backend_2.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
