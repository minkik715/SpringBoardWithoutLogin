package com.sparta.sparta_assignment_week3.controller;

import com.sparta.sparta_assignment_week3.dto.PostRequestDto;
import com.sparta.sparta_assignment_week3.dto.PostResponseDto;
import com.sparta.sparta_assignment_week3.model.Post;
import com.sparta.sparta_assignment_week3.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    //전체 글 조회
    @ResponseBody
    @GetMapping("/posts")
    public List<PostResponseDto> getPosts(){
        return postService.getPosts();
    }

    //글 등록
    @ResponseBody
    @PostMapping("/posts")
    public Post createPost(@RequestBody PostRequestDto postRequestDto){
        return postService.createPost(postRequestDto);
    }

    //특정 글 조회
    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model){

        PostResponseDto post = postService.getPost(id);
        String time = post.getTime().toString();
        model.addAttribute("id",post.getId());
        model.addAttribute("title" , post.getTitle());
        model.addAttribute("name", post.getName());
        model.addAttribute("time", time.substring(0, 19));
        model.addAttribute("contents", post.getContents());
        return "post";
    }

    //글 등록 페이지로 이동
    @GetMapping("/posts/create")
    public String createPostPage(){
        return "createPost";
    }

    @ResponseBody
    @DeleteMapping("/posts/{id}")
    public Long deletePost(@PathVariable Long id){
        postService.delete(id);

        return id;
    }

    @GetMapping("/posts/update/{id}")
    public String updatePostpage(@PathVariable Long id, Model model){
        PostResponseDto post = postService.getPost(id);
        model.addAttribute("info", post);
        return "updatePage";
    }

    @ResponseBody
    @PutMapping("/posts/{id}")
    public Post update(@PathVariable Long id,@RequestBody PostRequestDto postRequestDto){
        return postService.updatePost(id, postRequestDto);
    }


}
