package com.sergio.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sergio.dao.PostDao;
import com.sergio.entity.Author;
import com.sergio.entity.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostResolver implements GraphQLResolver<Author> {
    private PostDao postDao;

    public PostResolver(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<Post> getPosts(Author author) {
        List<Post> posts = postDao.getAuthorPosts(author.getId());
        posts.stream().forEach(post -> {
            post.setText("pepe");
        });
        return posts;
    }
}
