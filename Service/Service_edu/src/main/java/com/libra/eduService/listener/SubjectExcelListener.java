package com.libra.eduService.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.libra.eduService.common.Exception.GuliException;
import com.libra.eduService.entity.EduSubject;
import com.libra.eduService.entity.excel.SubjectData;
import com.libra.eduService.service.EduSubjectService;

public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    //手动实现service 依赖注入
    public EduSubjectService subjectService;
    public SubjectExcelListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }
    public SubjectExcelListener() {
    }


    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
          if (subjectData == null){
              throw new GuliException(20001,"文件数据为空");
          }


          //判断一级分类是否重复
          EduSubject exist1stSubject = this.exist1stSubject(subjectService,subjectData.getFirstSubjectName());
          if (exist1stSubject == null){
              exist1stSubject = new EduSubject();
              exist1stSubject.setParentId("0");
              exist1stSubject.setTitle(subjectData.getFirstSubjectName());
              subjectService.save(exist1stSubject);
          }

          String pid = exist1stSubject.getId();
          EduSubject exist2ndtSubject = this.exist2ndSubject(subjectService,subjectData.getFirstSubjectName(),pid);
        if (exist2ndtSubject == null){
            exist2ndtSubject = new EduSubject();
            exist2ndtSubject.setParentId(pid);
            exist2ndtSubject.setTitle(subjectData.getFirstSubjectName());
            subjectService.save(exist2ndtSubject);
        }

    }

    private EduSubject exist1stSubject(EduSubjectService eduSubjectService,String name){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",0);
        EduSubject firstSubject = subjectService.getOne(wrapper);
        return firstSubject;
    }

    private EduSubject exist2ndSubject(EduSubjectService eduSubjectService,String name,String pid){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",pid);
        EduSubject secondSubject = subjectService.getOne(wrapper);
        return secondSubject;
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}