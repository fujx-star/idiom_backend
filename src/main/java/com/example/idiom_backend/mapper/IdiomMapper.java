package com.example.idiom_backend.mapper;

import com.example.idiom_backend.bean.IdiomBean;
import com.example.idiom_backend.bean.XingIdiomBean;
import com.example.idiom_backend.bean.YiIdiomBean;
import com.example.idiom_backend.bean.YinIdiomBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdiomMapper {

    IdiomBean getIdiomByName(@Param("name") String name);

    IdiomBean getIdiomByIndex(@Param("index") int index);

    List<String> getIdiomByLikelyName(@Param("name") String name);

    List<IdiomBean> getAllIdiom();

    Integer getIdiomCount();

    Integer getXingIdiomCount();

    XingIdiomBean getXingIdiomByIndex(@Param("index") int index);

    Integer getYinIdiomCount();

    YinIdiomBean getYinIdiomByIndex(@Param("index") int index);

    Integer getYiIdiomCount();

    YiIdiomBean getYiIdiomByIndex(@Param("index") int index);
}
