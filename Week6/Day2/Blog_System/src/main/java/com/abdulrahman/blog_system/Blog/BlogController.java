package com.abdulrahman.blog_system.Blog;


import com.abdulrahman.blog_system.MyUser.MyUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping
    public List<Blog> getBlogs(@AuthenticationPrincipal MyUser myUser){
        return blogService.getBlogs(myUser);
    }
    @PostMapping
    public ResponseEntity addBlog(@AuthenticationPrincipal MyUser myUser, @RequestBody Blog blog){
        blogService.addBlog(myUser,blog);

        return ResponseEntity.status(HttpStatus.OK).body("Done! ");
    }
    @PutMapping("/{blog_id}")
    public ResponseEntity updateBlog(@AuthenticationPrincipal MyUser myUser, @RequestBody Blog blog,@PathVariable Integer blog_id){
        blogService.updateBlog(myUser,blog,blog_id);
        return ResponseEntity.status(HttpStatus.OK).body("Updated! ");
    }
    @DeleteMapping("/{blog_id}")
    public ResponseEntity deleteBlog(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer blog_id){
        blogService.deleteBlog(myUser,blog_id);

        return ResponseEntity.status(HttpStatus.OK).body("Deleted! ");
    }

    @GetMapping("/id/{blog_id}")
    public Blog getBlogById(@AuthenticationPrincipal MyUser myUser,@PathVariable Integer blog_id){
        return blogService.getBlogById(myUser,blog_id);
    }

    @GetMapping("/title/{blog_title}")
    public Blog getBlogByTitle(@AuthenticationPrincipal MyUser myUser,@PathVariable String blog_title){
        return blogService.getBlogByTitle(myUser,blog_title);
    }
}
