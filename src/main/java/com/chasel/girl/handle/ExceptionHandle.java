package com.chasel.girl.handle;

import com.chasel.girl.domain.Result;
import com.chasel.girl.exception.RuntimeCodeException;
import com.chasel.girl.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author XieLongzhen
 * @date 2018/7/16 14:40
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = RuntimeCodeException.class)
    @ResponseBody
    public Result handle(Exception e) {
        return ResultUtil.fail(100, e.getMessage());
    }
}
