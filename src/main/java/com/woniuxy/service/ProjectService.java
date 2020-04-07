package com.woniuxy.service;

import com.woniuxy.pojo.Project;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther: 秦浦华
 * @DATE: 2020/4/6   21:21
 */

public interface ProjectService {

    List<Project> queryBySkillgroup(Integer skillgroupId);
}
