package com.tencent.sxwx.wechat.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/3 0003.
 */
@Data
public class ResponseData implements Serializable {

    public String msg = "";

    public Object data;

    public boolean status;

}
