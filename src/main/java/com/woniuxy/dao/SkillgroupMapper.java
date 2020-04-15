package com.woniuxy.dao;

//import com.woniuxy.pojo.Skillgroup;
//import com.woniuxy.pojo.PageBean;
//
//import java.util.List;
//
///**
// * @author zhao
// * @create 2020/03/2020/3/26 23:17:33
// */
//public interface SkillgroupMapper {
//
//    List<Skillgroup> findAll();
//
//    List<Skillgroup> selectByPage(PageBean<Skillgroup> pageBean);
//
//    int countAll(PageBean<Skillgroup> pageBean);
//
//    void save(Skillgroup Skillgroup);
//
//    Skillgroup findOne(Integer SkillgroupId);
//
//    void update(Skillgroup Skillgroup);
//
//    void delete(Integer SkillgroupId);
//
//    Integer queryDoctorBySkillgroup(Integer skillgroupId);


/**
 * @auther: 鄢程宇
 *
 */
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Project;
import com.woniuxy.pojo.Skillgroup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillgroupMapper {
    void save(Skillgroup obj);
    void update(Skillgroup obj);
    void delete(Integer skillgroupId);
    Skillgroup findOne(Integer skillgroupId);
    List<Skillgroup> findAll();


    List<Skillgroup> selectByPage(PageBean<Skillgroup> pageBean);

    int countAll();

    void deletes(Integer[] skillgroupId);

}
