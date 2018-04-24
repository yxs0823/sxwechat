package com.tencent.sxwx.wechat.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/9.
 */
@Data
public class PageDTO<T> implements Serializable {

    public PageDTO() {

    }

    public String msg = "";

    public List<T> list;

    public Integer pageNo;

    public Long totalCount;

    public Integer totalPage;

    public boolean status;

}
