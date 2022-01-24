package com.sparta.sparta_assignment_week3.repository;


import com.sparta.sparta_assignment_week3.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findAllByOrderByModifiedAtDesc();
}
