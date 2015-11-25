package com.sabthok.aapp.Models;

/**
 * Created by Aayush on 11/21/2015.
 */
public class Sell extends Ad {
    private Integer l_price;
    private Integer h_price;

    public Sell(Integer id, Integer creator_id, Integer product, String location, String name, String description, String thumb_url, Integer l_price, Integer h_price) {
        super(id, creator_id, product, location, name, description, thumb_url);
        this.l_price = l_price;
        this.h_price = h_price;
    }

    public Integer getL_price() {
        return l_price;
    }

    public Integer getH_price() {
        return h_price;
    }
}
