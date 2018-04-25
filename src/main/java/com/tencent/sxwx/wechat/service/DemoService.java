package com.tencent.sxwx.wechat.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tencent.sxwx.wechat.bean.Demo;
import com.tencent.sxwx.wechat.dto.PageDTO;
import com.tencent.sxwx.wechat.dto.ResponseData;
import com.tencent.sxwx.wechat.mapper.DemoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/4/16 0016.
 */

@Service
public class DemoService {


    @Autowired
    private DemoMapper demoMapper;


    @Transactional
    public ResponseData addAppConfig(Demo demo) {
        ResponseData data = new ResponseData();


        String exist = demoMapper.findCongfigByName(demo.getName());

        if (!StringUtils.isEmpty(exist)) {
            data.setMsg("app名称已经存在");
            data.setStatus(false);
            return data;
        }
        demoMapper.addAppConfig(demo);
        data.setMsg("添加成功");
        data.setStatus(true);
        return data;
    }

    public ResponseData deleteAppConfig(Long id) {
        ResponseData data = new ResponseData();


        int result = demoMapper.deleteCongfig(id);
        data.setMsg(result <= 0 ? "删除失败" : "删除成功");
        data.setStatus(result <= 0 ? false : true);
        return data;
    }

    public ResponseData updateAppConfig(Demo appCongig) {
        ResponseData data = new ResponseData();


        int result = demoMapper.updateConfig(appCongig);
        data.setMsg(result <= 0 ? "修改失败" : "修改成功");
        data.setStatus(result <= 0 ? false : true);
        return data;
    }

    public ResponseData fingAppConfig(Long id) {
        ResponseData data = new ResponseData();
        data.setMsg("");
        data.setStatus(true);
        data.setData(demoMapper.findCongfigById(id));
        return data;
    }

    public PageDTO<Demo> findList(Integer pageNo, Integer pageSize) {
        PageDTO<Demo> dto = new PageDTO();
        Page<Demo> page = PageHelper.startPage(pageNo, pageSize);
        List<Demo> dataList = demoMapper.findAll();
        dto.setList(dataList);
        dto.setTotalCount(page.getTotal());
        dto.setPageNo(pageNo);
        dto.setTotalPage(page.getPages());
        dto.setStatus(true);
        return dto;
    }
}
