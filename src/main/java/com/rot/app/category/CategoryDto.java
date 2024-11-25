package com.rot.app.category;

import java.util.Date;

public class CategoryDto {

    private Long id;
    private String name;
    private String description;
    private Date creationDate;
    private Date lastUpdate;

    public CategoryDto() {
    }

    public CategoryDto(Long id, String name, String description, Date creationDate, Date lastUpdate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public static CategoryDto from(Category category) {
        return new CategoryDto(category.getId(), category.getName(), category.getDescription(), category.getCreationDate(), category.getLastUpdate());
    }

    public static Category to(CategoryDto categoryDto) {
        return new Category(categoryDto.getId(), categoryDto.getName(), categoryDto.getDescription(), categoryDto.getCreationDate(), categoryDto.getLastUpdate());
    }
}
