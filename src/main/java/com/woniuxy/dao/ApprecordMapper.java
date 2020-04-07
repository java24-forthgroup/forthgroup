package com.woniuxy.dao;

import com.woniuxy.pojo.Apprecord;
import com.woniuxy.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @auther: 秦浦华
 * @DATE: 2020/3/28   16:26
 */
@Mapper
public interface ApprecordMapper {

    int countAll(PageBean pageBean);

    List<Apprecord> findAllByPage(PageBean pageBean);
    List<Apprecord> findAll();

    void delete(int apprecordId);
    void book(Apprecord apprecord);
    Apprecord findOne(int apprecordId);
    void update (Apprecord apprecord);
    List<Apprecord> findAllByPageBean(PageBean pageBean);

}
