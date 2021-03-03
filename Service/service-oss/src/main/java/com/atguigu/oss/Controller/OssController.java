package com.atguigu.oss.Controller;

import com.atguigu.oss.Service.OssService;
import com.atguigu.oss.utils.R;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/eduoss/fileoss")
public class OssController {

    @Resource
    private OssService ossService;

    @PostMapping
    public R uploadFile(MultipartFile file){
        String url = ossService.uploadFile(file);
        return R.ok().data("url",url);
    }
}