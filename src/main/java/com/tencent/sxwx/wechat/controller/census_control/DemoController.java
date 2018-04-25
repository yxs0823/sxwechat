package com.tencent.sxwx.wechat.controller.census_control;

import com.tencent.sxwx.wechat.bean.Demo;
import com.tencent.sxwx.wechat.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Administrator on 2018/4/16 0016.
 */

@RestController
@RequestMapping("/demo")
@Api("demo管理")
public class DemoController {

    @Autowired
    private DemoService demoService;


    @PostMapping("/add")
    @ApiOperation("增加测试")
    public Object addData(@Valid @RequestBody Demo demo) {

        return demoService.addAppConfig(demo);


    }

    @PostMapping("/delete")
    @ApiOperation("根据id删除")
    public Object deleteData(Long id) {

        return demoService.deleteAppConfig(id);

    }


    @PostMapping("/update")
    @ApiOperation("根据id编辑")
    public Object updateData(@Valid @RequestBody Demo demo) {

        return demoService.updateAppConfig(demo);


    }


    @GetMapping("/list")
    @ApiOperation("列表分页")
    public Object getList(Integer pageNo, Integer pageSize) {

        if (pageNo == null) {
            pageNo = 1;
        }

        if (pageSize == null) {
            pageSize = 20;
        }

        return demoService.findList(pageNo, pageSize);


    }


    @GetMapping("/info")
    @ApiOperation("根据ID查看详情")
    public Object getInfo(Long id) {


        return demoService.fingAppConfig(id);


    }
}
