package com.libra.eduService.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = 1728630152803245471L;

    /**
     * 提示信息
     */
    private Boolean success;

    /**
     * 请求的cookie
     */
    private String cookie;

    /**
     * 返回具体内容
     */
    private T data;

    /**
     * 返回数量
     */
    private Integer count;
}