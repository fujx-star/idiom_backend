package com.example.idiom_backend.bean;

public class UserBean {
    private String name;
    private int sex;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserBean(String name, int sex, String password) {
        this.name = name;
        this.sex = sex;
        this.password = password;
    }

    public UserBean() {
    }
}
