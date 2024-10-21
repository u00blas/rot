package com.rot.app;

import com.rot.app.category.Category;
import com.rot.app.possibleanswers.PossibleAnswers;
import com.rot.app.topic.Topic;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AppTests {

    @Test
    void contextLoads() {
        List<Category> categoryList = MigrateData.getCategoryListFromCsv();

        for (Category category : categoryList) {
            System.out.println(category.getName());
        }
    }

    @Test
    void load_topics_from_csv() {
        List<Topic> topicList = MigrateData.getTopicListFromCsv();
        for (Topic topic : topicList) {
            System.out.println(topic.getName());
        }
    }
    @Test
    void load_possible_answers_from_csv() {
        List<PossibleAnswers> possibleAnswersList = MigrateData.getPossibleAnswersFromCsv();
        for (PossibleAnswers possibleAnswers : possibleAnswersList) {
            System.out.println(possibleAnswers);
        }
    }
}
