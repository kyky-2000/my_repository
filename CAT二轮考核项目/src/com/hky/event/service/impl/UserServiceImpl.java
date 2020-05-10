package com.hky.event.service.impl;

import com.hky.event.dao.UserDao;
import com.hky.event.dao.impl.UserDaoImpl;
import com.hky.event.entity.Condition;
import com.hky.event.entity.MoreInfo;
import com.hky.event.entity.User;
import com.hky.event.service.UserService;

import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    public User login(User user){
        return userDao.login(user.getMail(), user.getPassword());

    }

    public boolean register(User user){

        user.setStatus("未通过");
        boolean result = false;
        if(1 == userDao.register(user))
            result = true;
        return result;
    }

    public boolean update(User user){
        boolean result = false;
        if(1 == userDao.update(user))
            result = true;
        return result;
    }

    public MoreInfo showPersonalData(User user){
        MoreInfo moreInfo = userDao.searchHighLight(user.getID());
        User _user = userDao.showPersonalData(user.getID());
        moreInfo.setUser(_user);
        Map<String, String> map = userDao.searchLetters(user.getName());
        moreInfo.setMap(map);
        Map<String, String> history = userDao.searchTransferHistory(user.getName());
        moreInfo.setHistory(history);

        return moreInfo;
    }

    public User searchPersonalData(int ID){

        return userDao.showPersonalData(ID);
    }

    public boolean reply(Condition condition){
        return userDao.reply(condition.getMaster(), condition.getGuest(), condition.getContent());
    }

    public boolean updateInfo(Condition condition){
        if(1 == userDao.updateInfo(condition.getName(), condition.getStatus())){
            return true;
        }else{
            return false;
        }
    }
}
