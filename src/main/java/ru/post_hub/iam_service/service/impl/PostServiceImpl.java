package ru.post_hub.iam_service.service.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.post_hub.iam_service.exception.NotFoundException;
import ru.post_hub.iam_service.mapper.PostMapper;
import ru.post_hub.iam_service.model.constans.ApiErrorMessage;
import ru.post_hub.iam_service.model.dto.post.PostDTO;
import ru.post_hub.iam_service.model.entity.Post;
import ru.post_hub.iam_service.model.response.IamResponse;
import ru.post_hub.iam_service.repositoies.PostRepository;
import ru.post_hub.iam_service.service.PostService;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public IamResponse<PostDTO> getById(@NotNull Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.POST_INFO_BY_ID.getMessage(postId)));

        PostDTO postDTO = postMapper.toPostDTO(post);

        return IamResponse.success(postDTO);
    }
}
