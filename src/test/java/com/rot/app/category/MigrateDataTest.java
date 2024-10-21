package com.rot.app.category;

import com.rot.app.MigrateData;
import com.rot.app.question.Question;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MigrateDataTest {

    @Test
    void load_categories_from_csv() {
        List<Category> categoryList = MigrateData.getCategoriesFromCsv();
        for (Category category : categoryList) {
            System.out.println(category.getName());
        }
    }

    @Test
    void load_questions_from_csv(){
        List<Question> questionList = MigrateData.getQuestionsFromCsv();
        for (Question question : questionList) {
            System.out.println(question);
        }
    }
    @Test
    void get_category_by_name(){
        List<Category> categoryList = MigrateData.getCategoriesFromCsv();
        for(Category category : categoryList){
            System.out.println(category.getName());
        }
        Optional<Category> category = MigrateData.getCategoryByName("Vertrauen");
        System.out.println(category.get());
    }

}
