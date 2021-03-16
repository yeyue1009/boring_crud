package com.libra.eduService.service;

import com.libra.eduService.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.libra.eduService.entity.vo.CourseInfoVo;
import com.libra.eduService.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-03-08
 */
public interface EduCourseService extends IService<EduCourse> {
    String saveCourseInfo(CourseInfoVo courseInfoVo);

    //根据课程id查询课程基本信息
    CourseInfoVo getCourseInfo(String courseId);

    //修改课程信息
    void updateCourseInfo(CourseInfoVo courseInfoVo);

    //根据课程id查询课程确认信息
    CoursePublishVo publishCourseInfo(String id);
}
