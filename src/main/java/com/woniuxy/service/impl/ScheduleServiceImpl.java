package com.woniuxy.service.impl;

import com.woniuxy.dao.ScheduleMapper;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Schedule;
import com.woniuxy.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther: 秦浦华
 * @DATE: 2020/3/31   19:40
 */
@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired(required = false)
    ScheduleMapper scheduleMapper;

    @Override
    public int countAll(PageBean pageBean) {
        return 0;
    }

    @Override
    public List<Schedule> queryByDate(String date) {
        return scheduleMapper.queryByDate( date);
    }

    @Override
    public List<Schedule> findAllByPage(PageBean pageBean) {
        return scheduleMapper.findAllByPage(pageBean);
    }

    @Override
    public List<Schedule> findAll() {
        return null;
    }

    @Override
    public void delete(int scheduleId) {
        scheduleMapper.delete(scheduleId);
    }

    @Override
    public void save(Schedule schedule) {
        scheduleMapper.save(schedule);
    }

    @Override
    public Schedule findOne(int scheduleId) {
        return scheduleMapper.findOne(scheduleId);
    }

    @Override
    public void update(Schedule schedule) {
        scheduleMapper.update(schedule);
    }

    @Override
    public List<Schedule> findAllByPageBean(PageBean pageBean) {
        return null;
    }
}
