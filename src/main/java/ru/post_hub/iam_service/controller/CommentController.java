
package ru.post_hub.iam_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.post_hub.iam_service.service.CommentService;
import ru.post_hub.iam_service.service.impl.SecondCommentServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> addComment(@RequestBody Map<String, Object> requestBody) {
        String content = (String) requestBody.get("content");

        commentService.createComment(content);

        return new ResponseEntity<>("Comment added" + content, HttpStatus.OK);
    }

    @PostMapping("/switchService")
    public ResponseEntity<String> switchToSecondService(@RequestBody Map<String, Object> requestBody) {
        this.commentService = new SecondCommentServiceImpl();

        String content = (String) requestBody.get("content");
        commentService.createComment(content);

        return new ResponseEntity<>("Switched to SecondCommentService and added" + content, HttpStatus.OK);
    }
}
