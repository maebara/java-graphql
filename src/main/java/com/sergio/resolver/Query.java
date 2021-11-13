package com.sergio.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sergio.entity.Post;

import java.util.List;

public class Query implements GraphQLQueryResolver {
    private PostResolver postResolver;

    public Query(PostResolver postResolver) {
        this.postResolver = postResolver;
    }

    public List<Post> getAuthorPosts(String authorId) {
        return postDao.getAuthorPosts(authorId);
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return postDao.getRecentPosts(count, offset);
    }
}
