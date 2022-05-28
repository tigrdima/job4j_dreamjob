package ru.job4j.dream.service;

import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.PostStore;

import java.util.Collection;

public class PostService {
    private static final PostService INST = new PostService();

    private final PostStore postStore = PostStore.instOf();

    public PostService() {
    }

    public static PostService instOf() {
        return INST;
    }

    public void add(Post post) {
        postStore.add(post);
    }

    public Post findById(int id) {
        return postStore.findById(id);
    }

    public void update(Post post) {
       postStore.update(post);
    }

    public Collection<Post> findAll() {
        return postStore.findAll();
    }
}
