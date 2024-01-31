package com.tweetero.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dtos.TweetDTO;
import com.tweetero.api.models.TweetModel;
import com.tweetero.api.services.TweetService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tweets")
public class TweetController {
    
    final TweetService tweetService;
    TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping
    public ResponseEntity<TweetModel> createTweet(@RequestBody @Valid TweetDTO body) {
        Optional <TweetModel> tweet = tweetService.saveTweet(body);

        if (!tweet.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(tweet.get());
    }

    @GetMapping
    public ResponseEntity<List<TweetModel>> getAllTweets(){
        List<TweetModel> tweets = tweetService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tweets);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TweetModel>> getAllTweetsByUserId(@PathVariable Long userId){
        List<TweetModel> tweets = tweetService.findAllByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(tweets);
    }
    
}
