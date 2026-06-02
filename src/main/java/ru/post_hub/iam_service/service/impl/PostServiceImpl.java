package ru.post_hub.iam_service.service.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.post_hub.iam_service.exeption.NotFoundException;
import ru.post_hub.iam_service.model.constans.ApiErrorMessage;
import ru.post_hub.iam_service.model.dto.post.PostDTO;
import ru.post_hub.iam_service.model.entity.Post;
import ru.post_hub.iam_service.model.response.IamResponse;
import ru.post_hub.iam_service.repositoies.PostRepository;
import ru.post_hub.iam_service.service.PostService;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private  final PostRepository postRepository;

    @Override
    public IamResponse<PostDTO> getById(@NotNull Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.POST_INFO_BY_ID.getMessage(postId)));
    PostDTO postDTO = PostDTO.builder()
            .id(post.getId())
            .title(post.getTitle())
            .content(post.getContent())
            .likes(post.getLikes())
            .created(post.getCreated())
            .build();

    return IamResponse.success(postDTO);
    }
}
