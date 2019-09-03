package com.jinnjo.webfluxdemo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @Description
 * @Author hlantian
 * @Date Created in 17:34 2019/9/3
 */
@Getter
@Setter
@Document("tweets")
public class Tweet {
    @Id
    private String id;

    @NotBlank
    @Size(max = 140)
    private String text;

    @NotNull
    private Date createdAt = new Date();

    public Tweet() {
    }

    public Tweet(String id, String text) {
        this.id = id;
        this.text = text;
    }
}
