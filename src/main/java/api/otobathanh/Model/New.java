package api.otobathanh.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class New {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank (message = "Nội dung và bắt buộc điền")
    private String content;
    private String image;

    @NotBlank(message = "Tiêu đề bắt buộc điền")
    private String title;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}
