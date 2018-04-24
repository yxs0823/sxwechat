package com.tencent.sxwx.wechat.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tencent.sxwx.wechat.bean.AppConfig;
import com.tencent.sxwx.wechat.dto.PageDTO;
import com.tencent.sxwx.wechat.dto.ResponseData;
import com.tencent.sxwx.wechat.mapper.AppConfigMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/4/16 0016.
 */

@Service
public class AppConfigService {


    @Autowired
    private AppConfigMapper appConfigMapper;


    @Transactional
    public ResponseData addAppConfig(AppConfig appCongig) {
        ResponseData data = new ResponseData();


        String exist = appConfigMapper.findCongfigByName(appCongig.getAppName());

        if (!StringUtils.isEmpty(exist)) {
            data.setMsg("app名称已经存在");
            data.setStatus(false);
            return data;
        }
        appConfigMapper.addAppConfig(appCongig);
        data.setMsg("添加成功");
        data.setStatus(true);
        return data;
    }

    public ResponseData deleteAppConfig(Long id) {
        ResponseData data = new ResponseData();


        int result = appConfigMapper.deleteCongfig(id);
        data.setMsg(result <= 0 ? "删除失败" : "删除成功");
        data.setStatus(result <= 0 ? false : true);
        return data;
    }

    public ResponseData updateAppConfig(AppConfig appCongig) {
        ResponseData data = new ResponseData();


        int result = appConfigMapper.updateConfig(appCongig);
        data.setMsg(result <= 0 ? "修改失败" : "修改成功");
        data.setStatus(result <= 0 ? false : true);
        return data;
    }

    public ResponseData fingAppConfig(Long id) {
        ResponseData data = new ResponseData();
        data.setMsg("");
        data.setStatus(true);
        data.setData(appConfigMapper.findCongfigById(id));
        return data;
    }

    public PageDTO<AppConfig> findList(Integer pageNo, Integer pageSize) {
        PageDTO<AppConfig> dto = new PageDTO();
        Page<AppConfig> page = PageHelper.startPage(pageNo, pageSize);
        List<AppConfig> dataList = appConfigMapper.findAll();
        dto.setList(dataList);
        dto.setTotalCount(page.getTotal());
        dto.setPageNo(pageNo);
        dto.setTotalPage(page.getPages());
        dto.setStatus(true);
        return dto;
    }
}
