package com.sparta.sparta_assignment_week3.dto;

import com.sparta.sparta_assignment_week3.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Service
public class PostResponseDto {
    private String name;
    private String title;
    private String contents;
    private LocalDateTime time;
    private Long id;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.contents = post.getContents();
        this.name = post.getName();
        this.title = post.getTitle();
        this.time = post.getModifiedAt();
    }
}
