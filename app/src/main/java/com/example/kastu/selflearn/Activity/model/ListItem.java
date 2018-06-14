package com.example.kastu.selflearn.Activity.model;

public class ListItem {

    private String head;
    private String desc;

    private String imageUrl;
    private String[] imageUrls;

    private int like;
    private int hate;
    private int love;

    public ListItem(){

    }

    public ListItem(String head, String desc, String imageUrl, String[] imageUrls, int like, int hate, int love) {
        this.head = head;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.imageUrls = imageUrls;
        this.like = like;
        this.hate = hate;
        this.love = love;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
    }

    public ListItem(String head, String desc, String imageUrl, int like, int hate, int love) {
        this.head = head;
        this.desc = desc;
        this.like = like;
        this.hate = hate;
        this.love = love;
        this.imageUrl = imageUrl;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public int getLike() {
        return like;
    }

    public int getHate() {
        return hate;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setHate(int hate) {
        this.hate = hate;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public int getLove() {

        return love;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
