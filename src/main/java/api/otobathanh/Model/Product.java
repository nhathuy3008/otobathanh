package api.otobathanh.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Tên sản phẩm bắt buộc điền")
    private String name;

    @Column(length = 2000)
    private String description;

    private Double price;

    private String image;

    @ElementCollection
    private List<String> subImages;

    private LocalDateTime date;

    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
    }

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
