package com.hky.event.entity;

public class Condition {
    private int ID;
    private String name;
    private String gameCareer;
    private String status;
    private int start;
    private int currentPage;
    //一页所能展示的记录数
    private int number;
    private String master;
    private String guest;
    private String content;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGameCareer() {
        return gameCareer;
    }

    public void setGameCareer(String gameCareer) {
        this.gameCareer = gameCareer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", gameCareer='" + gameCareer + '\'' +
                ", status='" + status + '\'' +
                ", start=" + start +
                ", currentPage=" + currentPage +
                ", number=" + number +
                ", master='" + master + '\'' +
                ", guest='" + guest + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

