
package ru.post_hub.iam_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.post_hub.iam_service.service.CommentService;
import ru.post_hub.iam_service.service.impl.SecondCommentServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService defaultCommentService;
    private final CommentService advencedCommentService;

    @Autowired
    public CommentController(CommentService defaultCommentService,
                             @Qualifier("advencedCommentService") CommentService advencedCommentService) {
        this.defaultCommentService = defaultCommentService;
        this.advencedCommentService = advencedCommentService;
    }

    @PostMapping("/createDefaultComment")
    public ResponseEntity<String> createDefaultComment(@RequestBody Map<String, Object> requestBody) {
        String content = (String) requestBody.get("content");

        defaultCommentService.createComment(content);

        return new ResponseEntity<>("Default comment added" + content, HttpStatus.OK);
    }

    @PostMapping("/createAdvanced")
    public ResponseEntity<String> createAdvancedComment(@RequestBody Map<String, Object> requestBody) {

        String content = (String) requestBody.get("content");
        advencedCommentService.createComment(content);

        return new ResponseEntity<>("Advanced comment added" + content, HttpStatus.OK);
    }
}
