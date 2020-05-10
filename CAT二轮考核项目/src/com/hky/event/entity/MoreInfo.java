package com.hky.event.entity;

import java.util.List;
import java.util.Map;

public class MoreInfo {
    public String photo1;
    public String photo2;
    public String photo3;
    //查询到的用户收到的私信
    private Map<String, String> map;
    private Map<String, String> history;
    private User user;

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<String, String> getHistory() {
        return history;
    }

    public void setHistory(Map<String, String> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "MoreInfo{" +
                "photo1='" + photo1 + '\'' +
                ", photo2='" + photo2 + '\'' +
                ", photo3='" + photo3 + '\'' +
                ", map=" + map +
                ", history=" + history +
                ", user=" + user +
                '}';
    }
}
