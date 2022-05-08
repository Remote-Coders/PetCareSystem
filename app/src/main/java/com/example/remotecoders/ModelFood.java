package com.example.remotecoders;

public class ModelFood {
    private String name;
    private String description;
    private Integer price;
    private String imgurl;

    public ModelFood(String name, String description, Integer price, String imgurl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgurl = imgurl;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public ModelFood() {
    }

    public ModelFood(String name, String description, int price, String imgurl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgurl = imgurl;
    }


}
