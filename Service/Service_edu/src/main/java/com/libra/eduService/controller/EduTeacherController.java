package com.libra.eduService.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.libra.eduService.common.dto.TeacherDTO;
import com.libra.eduService.common.utils.ResultVOUtil;
import com.libra.eduService.common.vo.ResultVO;
import com.libra.eduService.entity.EduTeacher;
import com.libra.eduService.service.EduTeacherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-02-07
 */
@RestController
@RequestMapping("/eduService/edu-teacher")
public class EduTeacherController {

    @Resource
    private EduTeacherService eduTeacherService;

    @GetMapping("findAll")
    public ResultVO list(){
        return ResultVOUtil.success(eduTeacherService.list(null));
    }

    @DeleteMapping("{id}")
    public ResultVO removeTeacher(@PathVariable String id){
       boolean flag = eduTeacherService.removeById(id);
       if (flag){
           return ResultVOUtil.success();
       }else {
           return ResultVOUtil.error("删除失败");
       }
    }

    @GetMapping("page/{current}/{limit}")
    public ResultVO pageListTeacher(@PathVariable Long current,
                                    @PathVariable Long limit){
        Page<EduTeacher> page = new Page<>(current,limit);
        eduTeacherService.page(page,null);
        Integer count = Math.toIntExact(page.getSize());
        List<EduTeacher> teacherList = page.getRecords();
        return ResultVOUtil.success(teacherList,count);

    }

    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public ResultVO pageTeacherCondition(@PathVariable long current,@PathVariable long limit,
                                  @RequestBody(required = false) TeacherDTO teacherQuery) {
        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);

        //构建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        // 多条件组合查询
        // mybatis学过 动态sql
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        //判断条件值是否为空，如果不为空拼接条件
        if(!StringUtils.isEmpty(name)) {
            //构建条件
            wrapper.like("name",name);
        }
        if(level != null ) {
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create",end);
        }

        //调用方法实现条件查询分页
        eduTeacherService.page(pageTeacher,wrapper);
        Integer count = Math.toIntExact(pageTeacher.getTotal());//总记录数
        List<EduTeacher> records = pageTeacher.getRecords(); //数据list集合
        return ResultVOUtil.success(records,count);
    }


    @PostMapping("add")
    public ResultVO addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if (save){
            return ResultVOUtil.success();
        }else {
            return ResultVOUtil.error("添加失败");
        }
    }

    @GetMapping("get/{id}")
    public ResultVO getTeacher(@PathVariable String id){
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        if (eduTeacher != null){
            return ResultVOUtil.success(eduTeacher);
        }else {
            return ResultVOUtil.error("查询不到信息");
        }
    }

    @PutMapping("update")
    public ResultVO updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if (flag){
            return ResultVOUtil.success();
        }else {
            return ResultVOUtil.error("修改失败");
        }
    }
}

