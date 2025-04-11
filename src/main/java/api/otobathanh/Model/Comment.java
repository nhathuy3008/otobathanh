package api.otobathanh.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    @NotBlank(message = "Bình luận là bắt buộc điền")
    private String content;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private LocalDateTime date;

    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
    }
}
