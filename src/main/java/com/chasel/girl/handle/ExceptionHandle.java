package com.chasel.girl.handle;

import com.chasel.girl.domain.Result;
import com.chasel.girl.exception.StatusCodeRuntimeException;
import com.chasel.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author XieLongzhen
 * @date 2018/7/16 14:40
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof StatusCodeRuntimeException) {
            StatusCodeRuntimeException exception = (StatusCodeRuntimeException) e;
            return ResultUtil.fail(exception.getCode(), exception.getMessage());
        } else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.fail(-1, "未知错误");
        }
    }
}
