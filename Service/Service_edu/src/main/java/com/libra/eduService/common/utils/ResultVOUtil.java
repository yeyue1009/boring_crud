package com.libra.eduService.common.utils;

import com.libra.eduService.common.vo.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object object, String cookie) {
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(true);
        resultVO.setCookie(cookie);
        resultVO.setData(object);

        return resultVO;
    }

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(true);
        resultVO.setData(object);

        return resultVO;
    }

    public static ResultVO success(Object object, Integer count) {
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(true);
        resultVO.setData(object);
        resultVO.setCount(count);

        return resultVO;
    }

    public static ResultVO success(){
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(true);
        return resultVO;
    }

    public static ResultVO error(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(false);
        resultVO.setData(object);
        return resultVO;
    }
}