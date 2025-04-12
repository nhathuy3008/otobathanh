package api.otobathanh.Repository;

import api.otobathanh.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findBySongId(Long songId); // Phương thức để lấy bình luận theo bài hát
    long countBySongId(Long songId); // Phương thức để đếm bình luận theo bài hát
}