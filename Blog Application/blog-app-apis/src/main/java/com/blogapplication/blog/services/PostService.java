package com.blogapplication.blog.services;

import com.blogapplication.blog.entities.Post;
import com.blogapplication.blog.payloads.PostDto;
import com.blogapplication.blog.payloads.PostResponse;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto , Integer userId , Integer categoryId);

    //update
    PostDto updatePost(PostDto postDto , Integer postId);

    //delete
    void deletePost(Integer postId);


    //get all posts
    PostResponse getAllPOst(Integer pageNumber , Integer pageSize , String sortBy);

    //get single post
    PostDto getPostById(Integer postId);


    //get all post by category
    List<PostDto> getPostsByCategory(Integer categoryId);


    //get all post by user
    List<PostDto> getPostsByUsers(Integer userId);


    //searche post
    List<PostDto> searchPosts(String keyword);


}
