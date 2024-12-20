package com.example.mrusnique.dto;

public class CategoryDTO {
    private String name;
    private Long parentId;

    public CategoryDTO() {}
    public CategoryDTO(String name, Long parentId) {
        this.name = name;
        this.parentId = parentId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
