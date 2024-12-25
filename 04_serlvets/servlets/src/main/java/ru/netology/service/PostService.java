package ru.netology.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;
import ru.netology.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Component
public class PostService {
    private final PostRepository repository;

    @Autowired
    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        return repository.all();
    }

    public Optional<Post> getById(long id) {
        return repository.getById(id);
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public void removeById(long id) {
        if (!repository.getById(id).isPresent()) {
            throw new NotFoundException("Post with id " + id + " not found");
        }
        repository.removeById(id);
    }
}
