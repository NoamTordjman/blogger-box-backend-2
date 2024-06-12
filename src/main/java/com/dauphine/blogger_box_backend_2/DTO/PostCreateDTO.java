package com.dauphine.blogger_box_backend_2.DTO;

import java.time.LocalDateTime;

public class PostCreateDTO {

    private LocalDateTime date_creation;
    private String title;


    public void setDate_creation(LocalDateTime date_creation) {
        this.date_creation = date_creation;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate_creation() {
        return date_creation;
    }

    public String getTitle() {
        return title;
    }

    public PostCreateDTO(String title, LocalDateTime date_creation) {
        this.title = title;
        this.date_creation = date_creation;
    }
}
