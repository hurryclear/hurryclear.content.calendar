package com.hurryclear.contentcalendar.repository;

import com.hurryclear.contentcalendar.model.Content;
import com.hurryclear.contentcalendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    List<Content> findAllByTitleContains(String keyword);

    // this is query derivation, there are a lot to learn here
   @Query("""
        SELECT * FROM Content
        where status = :status
    """)
    List<Content> listByStatus(@Param("status") Status status);
}
