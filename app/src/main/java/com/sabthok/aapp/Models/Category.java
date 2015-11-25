package com.sabthok.aapp.Models;

/**
 * Created by Aayush on 11/21/2015.
 */
public class Category {
    private Integer id;
    private Integer parent;

    private String name;
    private String description;
    private String thumb_url;

    public Category(Integer id, Integer parent, String name, String description, String thumb_url) {
        this.id = id;
        this.parent = parent;
        this.name = name;
        this.description = description;
        this.thumb_url = thumb_url;
    }

    public Category(Integer id, String name, String description, String thumb_url) {
        this.id = id;
        this.parent = null;
        this.name = name;
        this.description = description;
        this.thumb_url = thumb_url;
    }

    public Integer getParent() {
        return parent;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getThumb_url() {
        return thumb_url;
    }
}
