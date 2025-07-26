package com.developer.LLD.CommentSection;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
+---------------+       +------------------+
|   UserService |<----->|      User        |
+---------------+       +------------------+

+----------------+       +-------------------+
| CommentService |<----->|     Comment       |
+----------------+       +-------------------+
     |      |                        |
     |      |                        v
     |      |                +-------------+
     |      +--------------->|   Like      |
     |                       +-------------+
     |
     v
+--------------------+
| CommentRepository  |
+--------------------+

 */
public class CommentHandler {
    public static void main(String[] args) {
    User user = new User("u1", "Ravi");
    CommentService commentService = new CommentService();

    Comment c1 = commentService.postComment(user, "First Comment!");
    Comment c2 = commentService.postComment(user, "Second Comment!");
    commentService.likeComment(c1.getId(), "u2");
    commentService.likeComment(c1.getId(), "u3");

    Comment reply = new Comment(UUID.randomUUID().toString(), "Reply to first", user);
    commentService.addReplyToComment(c1.getId(), reply);


    }
}
