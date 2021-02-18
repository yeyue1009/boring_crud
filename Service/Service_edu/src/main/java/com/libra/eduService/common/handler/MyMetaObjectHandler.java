package com.libra.eduService.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.sun.xml.internal.ws.spi.db.DatabindingException;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmtCreate",new Date(),metaObject);
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified",new DatabindingException(),metaObject);
    }
}