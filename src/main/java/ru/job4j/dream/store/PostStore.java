package ru.job4j.dream.store;

import ru.job4j.dream.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PostStore {
    private static final PostStore INST = new PostStore();
    private final AtomicInteger id = new AtomicInteger();
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private PostStore() {
        posts.put(1, new Post(1, "Junior Java Job",
                "Понимание принципов ООП. Знание Spring Framework (Hibernate)", "20/05/2022"));
        posts.put(2, new Post(2, "Middle Java Job",
                "Стек технологий: Java 8. Messaging (желательно Kafka)", "20/05/2022"));
        posts.put(3, new Post(3, "Senior Java Job",
                "Знание и опыт работы с web-технологиями, реляционными базами ", "20/05/2022"));
    }

    public void add(Post post) {
        posts.put(id.get(), post);
    }

    public static PostStore instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }
}
