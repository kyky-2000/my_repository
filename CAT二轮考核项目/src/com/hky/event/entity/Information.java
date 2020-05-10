package com.hky.event.entity;

public class Information {
    public int ID;
    public String name;
    public String introduce;
    public String photo;
    public String gameCareer1;
    public String gameCareer2;
    public String gameCareer3;
    public String salary;
    public String status;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getGameCareer1() {
        return gameCareer1;
    }

    public void setGameCareer1(String gameCareer1) {
        this.gameCareer1 = gameCareer1;
    }

    public String getGameCareer2() {
        return gameCareer2;
    }

    public void setGameCareer2(String gameCareer2) {
        this.gameCareer2 = gameCareer2;
    }

    public String getGameCareer3() {
        return gameCareer3;
    }

    public void setGameCareer3(String gameCareer3) {
        this.gameCareer3 = gameCareer3;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Information{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", photo='" + photo + '\'' +
                ", gameCareer1='" + gameCareer1 + '\'' +
                ", gameCareer2='" + gameCareer2 + '\'' +
                ", gameCareer3='" + gameCareer3 + '\'' +
                ", salary='" + salary + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
