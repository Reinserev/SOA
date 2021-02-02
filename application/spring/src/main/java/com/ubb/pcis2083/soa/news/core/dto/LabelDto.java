package com.ubb.pcis2083.soa.news.core.dto;

public class LabelDto {
    private Long id;

    private String name;

    public LabelDto() {}

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

    @Override
    public String toString() {
        return "LabelDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
