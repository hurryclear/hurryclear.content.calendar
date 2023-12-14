package com.hurryclear.contentcalendar.repository;

import com.hurryclear.contentcalendar.model.Content;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository

/*
This is not talking to database, but to keep a collection of pieces of content in memory
 */

public class ContentCollectionRepository {

    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return content;
    }

    public Optional<Content> findById(Integer id) {
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }


}
