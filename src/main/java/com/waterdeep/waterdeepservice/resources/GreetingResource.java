package com.waterdeep.waterdeepservice.resources;

import com.waterdeep.waterdeepservice.models.Article;
import com.waterdeep.waterdeepservice.models.Articles;
import com.waterdeep.waterdeepservice.models.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingResource {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/getArticles")
    public Articles article(@RequestHeader("Authorization") String authHeader) {
        System.out.println(authHeader);
        return new Articles(new ArrayList<>());
    }

}
