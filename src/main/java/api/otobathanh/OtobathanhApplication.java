package api.otobathanh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import api.otobathanh.Config.DotenvInitializer; // 👈 thêm import

@SpringBootApplication
public class OtobathanhApplication {

	public static void main(String[] args) {
		// 👇 load .env vào System properties trước khi Spring Boot chạy
		DotenvInitializer.get("DB_URL");

		SpringApplication.run(OtobathanhApplication.class, args);
	}

}
