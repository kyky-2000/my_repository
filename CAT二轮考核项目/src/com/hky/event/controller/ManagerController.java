package com.hky.event.controller;

import com.hky.event.annotation.Mapping;
import com.hky.event.entity.Condition;
import com.hky.event.entity.Information;
import com.hky.event.entity.ResultInfo;
import com.hky.event.entity.User;
import com.hky.event.service.ManagerService;
import com.hky.event.service.impl.ManagerServiceImpl;

import java.util.List;

@Mapping("manager")
public class ManagerController {

    private ManagerService  managerService = new ManagerServiceImpl();
    @Mapping("searchUsers")
    public ResultInfo searchUsers(Condition condition){
        List<User> list = managerService.searchUsersByStatus(condition);
        return new ResultInfo(200, "查找成功", list);
    }

    @Mapping("searchInfo")
    public ResultInfo searchInfo(Condition condition){
        List<Information> list = managerService.searchInfoByStatus(condition);
        return new ResultInfo(200, "查找成功", list);
    }

    @Mapping("delete")
    public ResultInfo delete(Condition condition){
        boolean result = managerService.delete(condition);
        if(result){
            return new ResultInfo(200, "操作成功", null);
        }else {
            return new ResultInfo(500, "服务器繁忙， 请稍后重试", null);
        }
    }

    @Mapping("update")
    public ResultInfo update(Condition condition){
        boolean result = managerService.update(condition);
        if(result){
            return new ResultInfo(200, "操作成功", null);
        }else {
            return new ResultInfo(500, "服务器繁忙， 请稍后重试", null);
        }
    }


}
