package com.libra.eduService.controller;


import com.libra.eduService.common.utils.R;
import com.libra.eduService.entity.subject.OneSubject;
import com.libra.eduService.service.EduSubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

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

    @PostMapping("addSubject")
    public R addSubject(MultipartFile file){

        eduSubjectService.saveSubject(file,eduSubjectService);
        return R.ok();
    }


    //课程分类列表（树形）
    @GetMapping("getAllSubject")
    public R getAllSubject() {
        //list集合泛型是一级分类
        List<OneSubject> list = eduSubjectService.getAllOneTwoSubject();
        return R.ok().data("list",list);
    }



}

