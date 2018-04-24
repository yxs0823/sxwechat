package com.tencent.sxwx.wechat.mapper;

import com.tencent.sxwx.wechat.bean.AppConfig;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2018/4/16 0016.
 */
public interface AppConfigMapper {


    @Insert("insert  into app_config  (bundle_id,app_name) values (#{bundleId},#{appName})")
    int addAppConfig(AppConfig appConfig);

    @Update("<script>" +
            "update app_config  set" +

            "<if test=\"bundleId!=null\">bundle_id =#{bundleId}</if>," +
            "<if test=\"appName!=null\">app_name =#{appName}</if>" +
            "where id =#{id}"+
            "</script>")
    int updateConfig(AppConfig appConfig);

    @Delete("delete  from app_config where id = #{id}")
    int deleteCongfig(Long id);


    @Select("select *  from app_config where id = #{id}")
    AppConfig findCongfigById(Long id);

    @Select("select app_name from app_config where app_name = #{appName}")
    String findCongfigByName(String appName);



    @Select("select *  from app_config ")
    List<AppConfig> findAll();
}
