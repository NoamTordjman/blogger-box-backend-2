package com.dauphine.blogger_box_backend_2.DTO;

import com.dauphine.blogger_box_backend_2.Category;

import java.time.LocalDateTime;
import java.util.UUID;

public class PostUpdateDTO {


    private String title;

    private String content;

    private Category category;

    private LocalDateTime date_creation;

    public PostUpdateDTO(UUID id, String title, String content, Category category) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.date_creation = LocalDateTime.now();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory_id(Category category) {
        this.category = category;
    }

    public LocalDateTime getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(LocalDateTime date_creation) {
        this.date_creation = date_creation;
    }

}




