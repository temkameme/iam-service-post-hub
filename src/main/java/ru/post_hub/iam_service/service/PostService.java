package ru.post_hub.iam_service.service;


import jakarta.validation.constraints.NotNull;
import ru.post_hub.iam_service.model.dto.post.PostDTO;
import ru.post_hub.iam_service.model.response.IamResponse;

public interface PostService {

    IamResponse<PostDTO> getById(@NotNull Integer id);
}
