package com.developer.LLD.CommentSection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CommentService {
    private final Map<String, Comment> commentStorage = new HashMap<>();

    public Comment postComment(User user, String text) {
        Comment comment = Comment.mapTo(user, text);
        commentStorage.put(comment.getId(), comment);
        return comment;
    }

    public void editComment(String commentId, String newComment) {
        Comment comment = commentStorage.get(commentId);
        if (comment != null) {
            comment.setContent(newComment);
        }
    }

    public void deleteComment(String commentId) {
        commentStorage.remove(commentId);
    }

    public void addReplyToComment(String parentCommentId, Comment reply) {
        Comment parentComment = commentStorage.get(parentCommentId);
        if (parentComment != null) {
            parentComment.setReplies(Collections.singletonList(reply));
        }
    }

    public void likeComment(String commentId, String userId) {
        Comment comment = commentStorage.get(commentId);
        if (comment != null) {
            comment.like(userId);
        }
    }
}
