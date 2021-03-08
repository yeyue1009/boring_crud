package com.libra.eduService.service;

import com.libra.eduService.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.libra.eduService.entity.vo.CourseInfoVo;

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
}
