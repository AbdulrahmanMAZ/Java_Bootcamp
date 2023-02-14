package com.abdulrahman.blog_system.Blog;

import com.abdulrahman.blog_system.MyUser.MyUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.abdulrahman.blog_system.exception.ApiException;


import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepo blogRepo;


    public List<Blog> getBlogs(MyUser myUser) {
        return blogRepo.findAllByMyUser_Id(myUser.getId());
    }

    public void addBlog(MyUser myUser, Blog blog) {
//        Blog blog = blogRepo.findBlogById(blog_id);
//        if (blog == null) {
//            throw new ApiException("not found");
//        }
        blog.setMyUser(myUser);
        blogRepo.save(blog);
    }
    public void updateBlog(MyUser myUser , Blog blog,Integer blog_id) {
        Blog blog_temp = blogRepo.findBlogById(blog_id);

        if (blog_temp == null) {
            throw new ApiException("not found");
        }
        MyUser myUser_temp = blog_temp.getMyUser();
        if (myUser_temp == null) {
            throw new ApiException("not found");
        }
        if (myUser_temp.getId() != myUser.getId()) {
            throw new ApiException("You are not authorized to edit this blog");
        }
        blog_temp.setBody(blog.getBody());
        blog_temp.setTitle(blog.getTitle());
        blogRepo.save(blog_temp);

    }

    public void deleteBlog(MyUser myUser, Integer blog_id) {
        Blog blog_temp = blogRepo.findBlogById(blog_id);

        if (blog_temp == null) {
            throw new ApiException("not found");
        }
        MyUser myUser_temp = blog_temp.getMyUser();
        if (myUser_temp == null) {
            throw new ApiException("not found");
        }

        if (myUser_temp.getId() != myUser.getId()) {
            throw new ApiException("You are not authorized to delete this blog");
        }

        blogRepo.delete(blog_temp);
    }

    public Blog getBlogById(MyUser myUser,Integer blog_id) {
        Blog blog_temp = blogRepo.findBlogById(blog_id);

        if (blog_temp == null) {
            throw new ApiException("not found");
        }
        MyUser myUser_temp = blog_temp.getMyUser();
        if (myUser_temp == null) {
            throw new ApiException("not found");
        }

        if (myUser_temp.getId() != myUser.getId()) {
            throw new ApiException("You are not authorized to delete this blog");
        }
        return blog_temp;
    }
    public Blog getBlogByTitle(MyUser myUser,String blog_title) {
        Blog blog_temp = blogRepo.findBlogByTitle(blog_title);
        if (blog_temp == null) {
            throw new ApiException("not found");
        }
        MyUser myUser_temp = blog_temp.getMyUser();
        if (myUser_temp == null) {
            throw new ApiException("not found");
        }

        if (myUser_temp.getId() != myUser.getId()) {
            throw new ApiException("You are not authorized to delete this blog");
        }

        return blog_temp;
    }

}
