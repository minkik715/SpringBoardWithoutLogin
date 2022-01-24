package com.sparta.sparta_assignment_week3.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostRequestDto {

    private String name;
    private String title;
    private String contents;
}
