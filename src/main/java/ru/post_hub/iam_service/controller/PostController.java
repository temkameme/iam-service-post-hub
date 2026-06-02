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
import ru.post_hub.iam_service.model.dto.post.PostDTO;
import ru.post_hub.iam_service.model.entity.Post;
import ru.post_hub.iam_service.model.response.IamResponse;
import ru.post_hub.iam_service.repositoies.PostRepository;
import ru.post_hub.iam_service.service.PostService;
import ru.post_hub.iam_service.utils.ApiUtils;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("${end.point.posts}")
public class PostController {

    private final PostService postService;

    @GetMapping("${end.points.id}")
    public ResponseEntity<IamResponse<PostDTO>> getPostById(
            @PathVariable(name = "id") Integer postId) {
        log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());

        IamResponse<PostDTO> response = postService.getById(postId);
        return ResponseEntity.ok(response);
    }
}
