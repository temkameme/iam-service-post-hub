package ru.post_hub.iam_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.post_hub.iam_service.model.constans.ApiErrorMessage;
import ru.post_hub.iam_service.model.constans.ApiLogMessage;
import ru.post_hub.iam_service.model.entity.Post;
import ru.post_hub.iam_service.repositoies.PostRepository;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("${end.point.posts}")
public class PostController {

    private final PostRepository postRepository;

    @GetMapping("${end.points.id}")
    public ResponseEntity<Post> getPostById(
            @PathVariable(name = "id") Integer postId) {
        log.info(ApiLogMessage.POST_INFO_BY_ID.getMessage(postId));

        return postRepository.findById(postId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    log.info(ApiErrorMessage.POST_INFO_BY_ID.getMessage(postId));
                    return ResponseEntity.notFound().build();
                });
    }
}
