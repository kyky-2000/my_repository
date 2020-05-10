package com.hky.event.controller;

import com.hky.event.annotation.Mapping;
import com.hky.event.entity.Condition;
import com.hky.event.entity.Information;
import com.hky.event.entity.PageBean;
import com.hky.event.entity.ResultInfo;
import com.hky.event.service.InfoService;
import com.hky.event.service.impl.InfoServiceImpl;

import java.util.List;

@Mapping("info")
public class InfoController {
    InfoService infoService = new InfoServiceImpl();

    @Mapping("searchPhotos")
    public ResultInfo searchPhotos(Condition condition){
        List list = infoService.searchPhotos();
        ResultInfo resultInfo = new ResultInfo(200, "查找成功", list);
        return resultInfo;
    }

    @Mapping("searchInfo")
    public ResultInfo searchInfo(Condition condition){
        PageBean pageBean = infoService.searchInfo(condition);
        return new ResultInfo(200, "查询成功", pageBean);
    }

    @Mapping("addInfo")
    public ResultInfo addInfo(Information information){
        boolean result = infoService.addInfo(information);
        if(result == true){
            return new ResultInfo(200, "申请成功", null);
        }else{
            return new ResultInfo(500, "服务器繁忙", null);
        }
    }
}
