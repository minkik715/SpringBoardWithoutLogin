package com.sparta.sparta_assignment_week3.service;

import com.sparta.sparta_assignment_week3.dto.PostRequestDto;
import com.sparta.sparta_assignment_week3.dto.PostResponseDto;
import com.sparta.sparta_assignment_week3.model.Post;
import com.sparta.sparta_assignment_week3.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    //모든 글 조회
    public List<PostResponseDto> getPosts(){
        List<Post> Posts = postRepository.findAllByOrderByModifiedAtDesc();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();

        for (Post post : Posts) {
            PostResponseDto postRequestDto = new PostResponseDto(post);
            postResponseDtos.add(postRequestDto);
        }
        return postResponseDtos;
    }

    // 글작성
    public Post createPost(PostRequestDto postRequestDto){
        Post post = new Post(postRequestDto);

        return postRepository.save(post);
    }

    //글 id로 조회
    public PostResponseDto getPost(Long id){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("글이 존재하지 않아요!")
        );
        System.out.println("name"+post.getName());
        System.out.println("title"+post.getTitle());
        PostResponseDto postResponseDto = new PostResponseDto(post);
        return postResponseDto;
    }


}
