package com.blogapplication.blog.services.impl;

import com.blogapplication.blog.entities.Comment;
import com.blogapplication.blog.entities.Post;
import com.blogapplication.blog.exceptions.ResourceNotFoundException;
import com.blogapplication.blog.payloads.CommentDto;
import com.blogapplication.blog.payloads.PostResponse;
import com.blogapplication.blog.repositories.CommentRepo;
import com.blogapplication.blog.repositories.PostRepo;
import com.blogapplication.blog.services.CommentService;
import org.hibernate.annotations.Array;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post" , "Post id" , postId));

        Comment comment = this.modelMapper.map(commentDto , Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepo.save(comment);

        return this.modelMapper.map(savedComment , CommentDto.class);
    }


    @Override
    public void deleteComment(Integer commentId) {
        Comment com = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment","commentId",commentId));
        this.commentRepo.delete(com);
    }
}
