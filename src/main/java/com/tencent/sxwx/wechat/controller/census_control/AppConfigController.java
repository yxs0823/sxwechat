package com.tencent.sxwx.wechat.controller.census_control;

import com.tencent.sxwx.wechat.bean.AppConfig;
import com.tencent.sxwx.wechat.service.AppConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Administrator on 2018/4/16 0016.
 */

@RestController
@RequestMapping("/appconfig")
@Api("app管理")
public class AppConfigController {

    @Autowired
    private AppConfigService appConfigService;


    @PostMapping("/add")
    @ApiOperation("新增app")
    public Object addData(@Valid @RequestBody AppConfig appConfig) {

        return appConfigService.addAppConfig(appConfig);


    }

    @PostMapping("/delete")
    @ApiOperation("根据id删除app应用")
    public Object deleteData(Long id) {

        return appConfigService.deleteAppConfig(id);

    }


    @PostMapping("/update")
    @ApiOperation("根据id编辑app应用")
    public Object updateData(@Valid @RequestBody AppConfig appConfig) {

        return appConfigService.updateAppConfig(appConfig);


    }


    @GetMapping("/list")
    @ApiOperation(value = "查询app列表", notes = "查询app列表")
    public Object getList(Integer pageNo, Integer pageSize) {

        if (pageNo == null) {
            pageNo = 1;
        }

        if (pageSize == null) {
            pageSize = 20;
        }

        return appConfigService.findList(pageNo, pageSize);


    }


    @GetMapping("/info")
    @ApiOperation("根据ID查看app信息")
    public Object getInfo(Long id) {


        return appConfigService.fingAppConfig(id);


    }
}
