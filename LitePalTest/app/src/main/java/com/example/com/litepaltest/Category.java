package com.example.com.litepaltest;

/**
 * Created by heyujie on 2017/6/24.
 */

public class Category {
    private int id;
    private String categoryName;
    private int categoryCode;

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getId() {

        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }
}
