package com.example.remotecoders;

public class ModelFood {
    private String category;
    private String name;
    private Integer price;
    private String description;
    private Integer quantity;
    private String imgurl;

    public ModelFood(String category, String name, Integer price, String description, String imgurl,Integer quantity) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imgurl = imgurl;
        this.quantity=quantity;

    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ModelFood() {
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
