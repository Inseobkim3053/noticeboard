package com.example.noticeboard.dto;


import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PostRequestDto {

    private String title;
    private String author;
    private String contents;
}
