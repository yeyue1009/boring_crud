package com.libra.eduService.service.impl;

import com.alibaba.excel.EasyExcel;
import com.libra.eduService.entity.EduSubject;
import com.libra.eduService.entity.excel.SubjectData;
import com.libra.eduService.listener.SubjectExcelListener;
import com.libra.eduService.mapper.EduSubjectMapper;
import com.libra.eduService.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-03-04
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file,EduSubjectService eduSubjectService) {
        try{
            InputStream in = file.getInputStream();

            EasyExcel.read(in, SubjectData.class,new SubjectExcelListener(eduSubjectService)).sheet().doRead();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
