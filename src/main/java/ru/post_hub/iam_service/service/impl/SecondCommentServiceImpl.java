package ru.post_hub.iam_service.service.impl;

import org.springframework.stereotype.Service;
import ru.post_hub.iam_service.service.CommentService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("advencedCommentService")
public class SecondCommentServiceImpl implements CommentService {

    private final List<String> comments =  new ArrayList<>();

    @Override
    public void createComment(String commentContent) {
        String advancedComment = "[" + LocalDateTime.now() + "] " + commentContent.toUpperCase();
        comments.add(commentContent);
        System.out.println(advancedComment);
    }
}
