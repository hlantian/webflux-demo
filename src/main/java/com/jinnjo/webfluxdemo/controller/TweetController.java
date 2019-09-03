package com.jinnjo.webfluxdemo.controller;

import com.jinnjo.webfluxdemo.model.Tweet;
import com.jinnjo.webfluxdemo.repo.TweetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Description
 * @Author hlantian
 * @Date Created in 17:51 2019/9/3
 */
@RestController
public class TweetController {

    @Resource
    private TweetRepository tweetRepository;

    @GetMapping("/tweets")
    public Flux<Tweet> getAllTweets() {
        return tweetRepository.findAll();
    }

    @PostMapping("/tweets")
    public Mono<Tweet> createTweets(@Valid @RequestBody Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @GetMapping("/tweets/{id}")
    public Mono<ResponseEntity<Tweet>> getTweetById(@PathVariable(value = "id") String id) {
        return tweetRepository.findById(id).map(savedTweet -> ResponseEntity.ok(savedTweet)).defaultIfEmpty(ResponseEntity.notFound().build());
    }


}
