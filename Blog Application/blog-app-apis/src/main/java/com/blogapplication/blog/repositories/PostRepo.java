package com.blogapplication.blog.repositories;

import com.blogapplication.blog.entities.Category;
import com.blogapplication.blog.entities.Post;
import com.blogapplication.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findAllByUser(User user);

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);

}
