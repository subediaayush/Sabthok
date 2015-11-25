package com.sabthok.aapp.Models;

/**
 * Created by Aayush on 11/21/2015.
 */
public abstract class Ad {
    private Integer id;
    private Integer creator_id;
    private Integer product_id;
    private String location;
    private String name;
    private String description;
    private String thumb_url;

    public Ad(Integer id, Integer creator_id, Integer product_id, String location, String name, String description, String thumb_url) {
        this.id = id;
        this.creator_id = creator_id;
        this.product_id = product_id;
        this.location = location;
        this.name = name;
        this.description = description;
        this.thumb_url = thumb_url;
    }


    public Integer getId() {
        return id;
    }

    public Integer getCreator_id() {
        return creator_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public String getLocation() {
        return location;
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
