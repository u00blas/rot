package com.rot.app;

import com.rot.app.category.Category;
import com.rot.app.proposal.Proposal;
import com.rot.app.topic.Topic;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AppTests {

    @Test
    void contextLoads() {
        List<Category> categoryList = MigrateData.getCategoriesFromCsv();

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
    void load_proposals_from_csv() {
        List<Proposal> proposalList = MigrateData.getProposalsFromCsv();
        for (Proposal proposal : proposalList) {
            System.out.println(proposal);
        }
    }
    @Test
    void load_categories_from_csv() {
        List<Category> categoryList = MigrateData.getCategoriesFromCsv();
        for (Category category : categoryList) {
            System.out.println(category.getName());
        }
    }
}
