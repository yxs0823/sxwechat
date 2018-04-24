package com.tencent.sxwx.wechat.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseList<T> {

    public List<T> list;

    public boolean status;

    public String msg = "";

    public Object data;


}
