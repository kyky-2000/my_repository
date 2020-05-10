package com.hky.event.entity;

public class User {
    public int ID;
    public String name;
    public int age;
    public String gender;
    public String profile;
    public String head;
    public String mail;
    public String password;
    public String lastTeam;
    public String identity;
    public String joinDate;
    //用户状态，记录着用户注册是否通过，是否被封禁
    public String status;
    //用户登录时输入的验证码
    private String checkCode1;
//    //前端获取到的后台发送的验证码
//    private String checkCode2;
    //用户登录时输入的邮箱验证码
    private String mailCode1;
    //前端获取到的后台发送的邮箱验证码
    private String mailCode2;


    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastTeam() {
        return lastTeam;
    }

    public void setLastTeam(String lastTeam) {
        this.lastTeam = lastTeam;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMailCode1() {
        return mailCode1;
    }

    public void setMailCode1(String mailCode1) {
        this.mailCode1 = mailCode1;
    }

    public String getMailCode2() {
        return mailCode2;
    }

    public void setMailCode2(String mailCode2) {
        this.mailCode2 = mailCode2;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

        public String getCheckCode1() {
        return checkCode1;
    }

    public void setCheckCode1(String checkCode1) {
        this.checkCode1 = checkCode1;
    }
//
//    public String getCheckCode2() {
//        return checkCode2;
//    }
//
//    public void setCheckCode2(String checkCode2) {
//        this.checkCode2 = checkCode2;
//    }


    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", profile='" + profile + '\'' +
                ", head='" + head + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", lastTeam='" + lastTeam + '\'' +
                ", identity='" + identity + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", status='" + status + '\'' +
                ", mailCode1='" + mailCode1 + '\'' +
                ", mailCode2='" + mailCode2 + '\'' +
                '}';
    }

}
