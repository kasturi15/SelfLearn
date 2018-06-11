package com.example.kastu.selflearn.Activity.model;

public class ListItem {

    private String head;
    private String desc;

    private int like;
    private int hate;
    private int love;


    public ListItem(String head, String desc, int like, int hate, int love) {
        this.head = head;
        this.desc = desc;
        this.like = like;
        this.hate = hate;
        this.love = love;
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

    public int getLove() {
        return love;
    }
}
