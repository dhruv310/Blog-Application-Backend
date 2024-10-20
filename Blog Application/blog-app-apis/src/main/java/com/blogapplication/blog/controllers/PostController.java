package com.blogapplication.blog.controllers;

import com.blogapplication.blog.config.AppConstant;
import com.blogapplication.blog.entities.Post;
import com.blogapplication.blog.payloads.ApiResponse;
import com.blogapplication.blog.payloads.PostDto;
import com.blogapplication.blog.payloads.PostResponse;
import com.blogapplication.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId ,
            @PathVariable Integer categoryId){

        PostDto createPost = this.postService.createPost(postDto , userId, categoryId);
        return new ResponseEntity<PostDto>(createPost , HttpStatus.CREATED);


    }

    //get by user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId) {
        List<PostDto> posts = this.postService.getPostsByUsers(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    //get by category

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {
        List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    //get all posts
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNumber", defaultValue = "" + AppConstant.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "" + AppConstant.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy
    ) {
        PostResponse postResponse = this.postService.getAllPOst(pageNumber, pageSize, sortBy);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }



    //get post detail by id
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){

        PostDto postDto = this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(postDto , HttpStatus.OK);
    }

    //delete post

    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ApiResponse("Post successsfully deleted !" ,true);
    }

    //update post

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto , @PathVariable Integer postId){
        PostDto updatePost = this.postService.updatePost(postDto , postId);
        return new ResponseEntity<PostDto>(updatePost , HttpStatus.OK);

    }

    //searche
    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable ("keywords") String keywords){
        List<PostDto> result = this.postService.searchPosts(keywords);
        return new ResponseEntity<List<PostDto>>(result , HttpStatus.OK);

    }

}
