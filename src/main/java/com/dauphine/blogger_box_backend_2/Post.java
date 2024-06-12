package com.dauphine.blogger_box_backend_2;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Post")
public class Post {

    @Column(name="id")
    @Id
    private UUID id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;


    @JoinColumn(name="category_id")
    @ManyToOne
    private Category category;

    @Column(name = "created_date")
    private LocalDateTime date_creation;

    public Post(UUID id, String title, String content, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.date_creation = LocalDateTime.now();
    }

    public Post(String title, Category category) {
        this.title = title;
        this.category = category;
        this.date_creation = LocalDateTime.now();
    }

    public Post() {
    }

    public Post(String title) {
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

