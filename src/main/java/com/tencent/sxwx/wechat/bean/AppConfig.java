package com.tencent.sxwx.wechat.bean;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Administrator on 2018/4/16 0016.
 */
@Data
public class AppConfig {

    private Long id;

    @NotBlank(message = "appname不能为空")
    private String appName;

    @NotBlank(message = "bundleId")
    private String bundleId;

}
