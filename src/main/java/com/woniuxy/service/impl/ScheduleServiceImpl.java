package com.woniuxy.service.impl;

import com.woniuxy.dao.ScheduleMapper;
import com.woniuxy.dao.SourceMapper;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Schedule;
import com.woniuxy.pojo.Source;
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
    @Autowired
    SourceMapper sourceMapper;

    @Override
    public int countAll(PageBean pageBean) {
        return scheduleMapper.countAll(pageBean);
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

        Schedule schedule = scheduleMapper.findOne(scheduleId);
        System.out.println(schedule);

        scheduleMapper.delete(scheduleId);
        sourceMapper.delete(schedule.getSource().getSourceId());

    }
    //增加排班，并且对应增加对应的号源池
    @Override
    public void save(Schedule schedule) {
        Source source = new Source();
        source.setSkillgroupId(schedule.getSkillgroup().getSkillgroupId());
        source.setSourceNum(300);
        source.setTypeId(1);
        source.setQueueId(null);

        sourceMapper.save(source);

        int num =source.getSourceId();
        System.out.println(num);
        source.setSourceId(num);
        schedule.setSource(source);
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

    @Override
    public Schedule queryDatedBySkillgroup(Schedule schedule) {
        return scheduleMapper.queryDatedBySkillgroup(schedule);
    }

    @Override
    public Schedule queryBySchedule(Schedule schedule) {
        return scheduleMapper.queryBySchedule(schedule);
    }
}
