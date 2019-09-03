package com.jinnjo.webfluxdemo.repo;

import com.jinnjo.webfluxdemo.model.Tweet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author hlantian
 * @Date Created in 17:46 2019/9/3
 */
@Repository
public interface TweetRepository extends ReactiveMongoRepository<Tweet,String> {
}
