package com.developer.LLD.CommentSection;

import java.time.LocalDateTime;
import java.util.List;

public class Comment {
    private String id;
    private String content;
    private User author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String parentId; // null for top-level comments
    private List<Comment> replies;

    public void setAuthor(User author) {
        this.author = author;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public User getAuthor() {
        return author;
    }
    public String getContent() {
        return content;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public String getId() {
        return id;
    }
    public String getParentId() {
        return parentId;
    }
    public List<Comment> getReplies() {
        return replies;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

}
