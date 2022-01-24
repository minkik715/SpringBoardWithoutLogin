package com.sparta.sparta_assignment_week3.model;

import com.sparta.sparta_assignment_week3.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    public Post(PostRequestDto postRequestDto) {
        this.name = postRequestDto.getName();
        this.title = postRequestDto.getTitle();
        this.contents = postRequestDto.getContents();
    }
}
