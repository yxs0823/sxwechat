package com.tencent.sxwx.wechat.mapper;

import com.tencent.sxwx.wechat.bean.Demo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2018/4/16 0016.
 */
public interface DemoMapper {


    @Insert("insert  into test  (name) values (#{name})")
    int addAppConfig(Demo demo);

    @Update("<script>" +
            "update test  set" +

            "<if test=\"name!=null\">name =#{name}</if>," +
            "where id =#{id}"+
            "</script>")
    int updateConfig(Demo demo);

    @Delete("delete  from test where id = #{id}")
    int deleteCongfig(Long id);


    @Select("select *  from test where id = #{id}")
    Demo findCongfigById(Long id);

    @Select("select name from test where name = #{name}")
    String findCongfigByName(String name);



    @Select("select *  from test ")
    List<Demo> findAll();
}
