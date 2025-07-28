package com.developer.LLD.CommentSection;

import java.util.List;

public interface CommentRepository {

    void save(Comment comment);

    Comment findById(String commentId);

    List<Comment> findByParentId(String parentId);

    void delete(String commentId);

    List<Comment> findByEntityId(String entityId);

}
