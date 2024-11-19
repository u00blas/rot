package com.rot.app.category;

import com.rot.app.migration.MigrateData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MigrateRawDataTest {

    @Test
    void load_categories_from_csv() {
        List<Category> categoryList = MigrateData.getCategoriesFromCsv();
        for (Category category : categoryList) {
            System.out.println(category.getName());
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
