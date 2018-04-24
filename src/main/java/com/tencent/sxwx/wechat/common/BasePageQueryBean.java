package com.tencent.sxwx.wechat.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class BasePageQueryBean implements Serializable{
    private static final long serialVersionUID = 5302537094185140652L;
    private int pageNo;
    private int pageSize;
}
