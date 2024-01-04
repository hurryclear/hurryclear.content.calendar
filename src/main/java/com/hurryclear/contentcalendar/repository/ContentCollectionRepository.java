package com.hurryclear.contentcalendar.repository;

import com.hurryclear.contentcalendar.model.Content;
import com.hurryclear.contentcalendar.model.Status;
import com.hurryclear.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository

/*
This is not talking to database, but to keep a collection of pieces of content in memory
 */

public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    // Get
    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }


    public void save(Content content) {
//        contentList.removeIf(c -> c.id().equals(content.id())); // In my case I don't need this, if I use it, post will not work
        contentList.add(content);
    }

    @PostConstruct
    private void init() {
        Content content = new Content(
                1,
                "My First Blog Post.",
                "my first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );
        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
