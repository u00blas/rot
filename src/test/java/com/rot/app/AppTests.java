package com.rot.app;

import com.rot.app.category.Category;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AppTests {

	@Test
	void contextLoads() {
		List<Category> categoryList = MigrateData.getCategoryListFromCsv();
	}

}
