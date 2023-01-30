package com.example.pizza_4_u.Cus_Menu;

import java.io.Serializable;

public class CusFood implements Serializable {
    private String name;
    private String price;
    private byte[] image;

    public CusFood(String name, String price, byte[] image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
