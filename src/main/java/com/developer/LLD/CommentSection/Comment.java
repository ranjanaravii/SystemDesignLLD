package com.developer.LLD.CommentSection;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class Comment {
    private String id;
    private String content;
    private User author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String parentId; // null for top-level comments
    private List<Comment> replies = new ArrayList<>();
    private Set<String> likedUserIds = new HashSet<>();

    public Comment(String id, String content, User user) {
        this.author = user;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.id = id;
    }

    public Comment() {
        // Default constructor
    }

    public static Comment mapTo(User user, String text) {
        Comment comment = new Comment();
        comment.setAuthor(user);
        comment.setContent(text);
        comment.setCreatedAt(LocalDateTime.now());
        comment.setId(UUID.randomUUID().toString());
        return comment;
    }

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

    public Set<String> getLikedUserIds() {
        return likedUserIds;
    }

    public void setLikedUserIds(Set<String> likedUserIds) {
        this.likedUserIds = likedUserIds;
    }

    public int getLikeCount() {
        return likedUserIds.size();
    }

    public void like(String userId) {
        likedUserIds.add(userId);
    }


     public List<Comment> getRepliesSortedByLikes() {
        return replies.stream()
            .sorted((a, b) -> Integer.compare(b.getLikeCount(), a.getLikeCount()))
            .collect(Collectors.toList());
    }

}
