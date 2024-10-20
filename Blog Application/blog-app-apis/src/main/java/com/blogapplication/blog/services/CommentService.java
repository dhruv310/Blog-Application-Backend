package com.blogapplication.blog.services;

import com.blogapplication.blog.payloads.CommentDto;
import com.blogapplication.blog.repositories.CommentRepo;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto , Integer postId);
    void deleteComment(Integer commentId);
}
