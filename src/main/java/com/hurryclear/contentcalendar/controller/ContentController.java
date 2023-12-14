package com.hurryclear.contentcalendar.controller;

import com.hurryclear.contentcalendar.model.Content;
import com.hurryclear.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/*
@RestController
The @RestController annotation is a specialized version of the @Controller annotation.
It indicates that the class is a controller, and its methods return data rather than a view.
It's a convenient way to combine the @Controller and @ResponseBody annotations.
 */
@RestController

/*
@RequestMapping
The @RequestMapping annotation at the class level specifies the base path
for all the methods in the controller.
In this case, all methods in ContentController will handle requests with paths starting from "/api/content".
*/
@RequestMapping("/api/content")

/*
what is controller?
Controller is a class that accept request and return a response
And in spring boot application we call Spring MVC controller
*/

public class ContentController {

    private final ContentCollectionRepository repository;


    @Autowired //if you only have one public constructor in your class, it is implicit, so you don't need Autowired
    public ContentController(ContentCollectionRepository repository) {

        this.repository = repository;
        /*
        repository = new ContentCollectionRepository();
        why we don't need to create new instance, that's because spring frame does it for us
        through annotation "Repository" we give to the class "ContentCollectionRepository"

        */
    }

    /*
    @GetMapping
    The @GetMapping annotation is used to map HTTP GET requests to specific handler methods in the controller.
    This example: The first one (@GetMapping("")) maps to the base path ("/api/content") and
    returns a list of all contents using the findAll method of the injected ContentCollectionRepository.
     */
    @GetMapping("")
    public List<Content> findALL() {
        return repository.findAll();
    }


    // Create Read Update Delete - filter | paging and sorting |

    /*
    The second one (@GetMapping("/{id}")) maps to a path with a variable part (/{id}).
    It takes the id as a path variable and returns an Optional<Content> by calling the findById method of the repository.
     */
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        // throw out an exception when with path variable can't find the content
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }


    // Create
    @ResponseStatus(HttpStatus.CREATED) // When we create sth, we want to see it has been created
    /*
    what does the method "create" create?
     */
    @PostMapping("")
    public void create(@RequestBody Content content) {
        repository.save(content);
    }


    // Update
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if(!repository.existById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");
        }
        repository.save(content);
    }


    // Delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.delete(id);
    }
}
