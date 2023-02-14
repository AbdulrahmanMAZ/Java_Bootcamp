package com.abdulrahman.blog_system.Blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Integer> {
     Blog findBlogById(Integer id);
     List<Blog> findAllByMyUser_Id(Integer id);

     Blog findBlogByTitle(String title);

}
