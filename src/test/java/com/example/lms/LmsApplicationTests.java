package com.example.lms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
		properties = {
				"spring.profiles.active=test",
				"spring.datasource.url=jdbc:h2:mem:testdb",
				"spring.jpa.hibernate.ddl-auto=create-drop"
		}
)
class LmsApplicationTests {
	@Test
	void contextLoads() {
		// Тест проверяет только загрузку контекста
	}
}