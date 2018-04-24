package com.tencent.sxwx.wechat.controller.census_control;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("请求控制测试")
public class test {



    @ApiOperation("请求测试")
    @GetMapping("/hi")
    public Object sayHello(){

        return "hello world";
    }
}
