package com.sabthok.aapp.Models;

/**
 * Created by Aayush on 11/21/2015.
 */
public class User {
    private Integer id;

    private String fname;
    private String lname;
    private String thumb_url;

    public User(Integer id, String fname, String lname, String thumb_url) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.thumb_url = thumb_url;
    }

    public Integer getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getThumb_url() {
        return thumb_url;
    }
}
