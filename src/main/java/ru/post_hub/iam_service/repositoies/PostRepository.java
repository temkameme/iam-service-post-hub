package ru.post_hub.iam_service.repositoies;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.post_hub.iam_service.model.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
