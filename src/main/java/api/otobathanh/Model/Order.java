package api.otobathanh.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private LocalDateTime date;

    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
        this.status = Status.PENDING; // ✅ mặc định là PENDING khi tạo mới
    }

    @NotBlank(message = "Số điện thoại không được để trống.")
    @Pattern(regexp = "^\\d{10,15}$", message = "Số điện thoại không hợp lệ.")
    private String phoneNumber;

    @NotBlank(message = "Email không được để trống.")
    @Email(message = "Email không hợp lệ.")
    private String email;

    private Double total;

    @Column(length = 100)
    private String note;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    public enum PaymentMethod {
        CASH, VNPAY, MOMO
    }

    // ✅ Thêm status order
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public enum Status {
        PENDING, PROCESSING, COMPLETED, CANCELLED
    }

}

