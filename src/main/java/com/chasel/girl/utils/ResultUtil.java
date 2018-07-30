package com.chasel.girl.utils;

import com.chasel.girl.domain.Result;

/**
 * @author XieLongzhen
 * @date 2018/7/16 10:33
 */
public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(200);
        result.setMessage("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result fail(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

}
