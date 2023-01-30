package com.example.pizza_4_u.Cus_Cart;

public class CartItemModel {

    private String name;
    private int price,qty,q_total,id;

    public CartItemModel(int id,String name, int price, int qty, int q_total) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.q_total = q_total;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getQ_total() {
        return q_total;
    }

    public void setQ_total(int q_total) {
        this.q_total = q_total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
