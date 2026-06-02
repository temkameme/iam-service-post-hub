package ru.post_hub.iam_service.service.impl;

import org.springframework.stereotype.Service;
import ru.post_hub.iam_service.service.CommentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final List<String> comments =  new ArrayList<>();

    @Override
    public void createComment(String commentContent) {
        comments.add(commentContent);
    }
}
