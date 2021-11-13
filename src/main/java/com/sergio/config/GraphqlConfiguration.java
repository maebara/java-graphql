package com.sergio.config;

import com.sergio.dao.AuthorDao;
import com.sergio.dao.PostDao;
import com.sergio.entity.Author;
import com.sergio.entity.Post;
import com.sergio.resolver.AuthorResolver;
import com.sergio.resolver.PostResolver;
import com.sergio.resolver.Query;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class GraphqlConfiguration {
    @Bean
    public PostDao postDao() {
        List<Post> posts = new ArrayList<>();
        for (int postId = 0; postId < 10; ++postId) {
            for (int authorId = 0; authorId < 10; ++authorId) {
                Post post = new Post();
                post.setId("Post" + authorId + postId);
                post.setTitle("Post " + authorId + ":" + postId);

                post.setAuthorId("Author" + authorId);
                posts.add(post);
            }
        }
        return new PostDao(posts);
    }

    @Bean
    public AuthorDao authorDao() {
        List<Author> authors = new ArrayList<>();
        for (int authorId = 0; authorId < 10; ++authorId) {
            Author author = new Author();
            author.setId("Author" + authorId);
            author.setName("Author " + authorId);
            author.setThumbnail("http://example.com/authors/" + authorId);
            authors.add(author);
        }
        return new AuthorDao(authors);
    }

    @Bean
    public PostResolver postResolver(PostDao postDao) {
        return new PostResolver(postDao);
    }

    @Bean
    public AuthorResolver authorResolver(AuthorDao authorDao) {
        return new AuthorResolver(authorDao);
    }

    @Bean
    public Query query(PostDao postDao) {
        return new Query(postDao);
    }


}
