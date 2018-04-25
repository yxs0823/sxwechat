package com.tencent.sxwx.wechat.bean;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Administrator on 2018/4/16 0016.
 */
@Data
public class Demo {

    private Long id;

    @NotBlank(message = "姓名不能为空")
    private String name;

}
