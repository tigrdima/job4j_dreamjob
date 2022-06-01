package ru.job4j.dream.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.PostDBStore;

import java.util.Collection;
import java.util.List;

@ThreadSafe
@Service
public class PostService {
    private final PostDBStore postDBStoree;
    private final CityService cityService;

    public PostService(PostDBStore postDBStoree, CityService cityService) {
        this.postDBStoree = postDBStoree;
        this.cityService = cityService;
    }

    public void add(Post post) {
        postDBStoree.add(post);
    }

    public Post findById(int id) {
        return postDBStoree.findById(id);
    }

    public void update(Post post) {
       postDBStoree.update(post);
    }

    public Collection<Post> findAll() {
        List<Post> posts = postDBStoree.findAll();
        posts.forEach(
                post -> post.setCity(
                        cityService.findById(post.getCity().getId())
                )
        );
        return posts;
    }
}
