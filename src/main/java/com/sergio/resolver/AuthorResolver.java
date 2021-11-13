package com.sergio.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sergio.dao.AuthorDao;
import com.sergio.entity.Author;
import com.sergio.entity.Post;

public class AuthorResolver implements GraphQLResolver<Post> {
    private AuthorDao authorDao;

    public AuthorResolver(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public Author getAuthor(Post post) {
        return authorDao.getAuthor(post.getAuthorId())
                .orElseThrow(RuntimeException::new);
    }
}
