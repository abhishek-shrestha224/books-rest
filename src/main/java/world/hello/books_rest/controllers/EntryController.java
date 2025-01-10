package world.hello.books_rest.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryController {
    @GetMapping("/")
    public Map<String, String> readRoot() {
        return Map.of("Hello", "World");
    }
}
