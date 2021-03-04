package com.libra.eduService.controller;


import com.libra.eduService.common.utils.R;
import com.libra.eduService.service.EduSubjectService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/eduService/edu-subject")
public class EduSubjectController {

    @Resource
    private EduSubjectService eduSubjectService;

    @PostMapping
    public R addSubject(MultipartFile file){

        eduSubjectService.saveSubject(file,eduSubjectService);

        return R.ok();

    }


}

