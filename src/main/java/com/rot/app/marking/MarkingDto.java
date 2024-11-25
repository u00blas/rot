package com.rot.app.marking;

public class MarkingDto {

    private Long id;
    private String name;
    private String description;

    public MarkingDto() {
    }

    public MarkingDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public static MarkingDto toDto(Marking marking) {
        return new MarkingDto(marking.getId(), marking.getName(), marking.getDescription());
    }

    public static Marking fromDto(MarkingDto markingDto) {
        return new Marking(markingDto.getId(), markingDto.getName(), markingDto.getDescription());
    }
}
