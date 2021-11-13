package com.sergio.dao;

import com.sergio.entity.Post;

import java.util.List;
import java.util.stream.Collectors;

public class    PostDao {
    private List<Post> posts;

    public PostDao(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return posts.stream()
                .skip(offset)
                .limit(count)
                .collect(Collectors.toList());
    }

    public List<Post> getAuthorPosts(String authorId) {
        return posts.stream()
                .filter(post -> authorId.equals(post.getAuthorId()))
                .collect(Collectors.toList());
    }
}
