package com.amio.cts.exceptions;

import com.amio.cts.common.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * 全局Controller异常增强处理类
 *
 * @author : zhenfeng.liu
 * @date : 2018/9/4 17:24
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handleException(HttpServletRequest request, Exception ex) {
        if (ex instanceof SysUserException) {
            logger.error("SysUserException code:{}, msg:{}", ((SysUserException) ex).getSysUserErrorCode().getCode(),
                    ((SysUserException) ex).getSysUserErrorCode().getMsg());
            return new Response(((SysUserException) ex).getSysUserErrorCode().getCode(),
                    ((SysUserException) ex).getSysUserErrorCode().getMsg(), LocalDateTime.now());
        } else {
            Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
            if (null == statusCode) {
                statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
            }
            logger.error("Exception error:{}", ex);
            return new Response(String.valueOf(statusCode), ex.getMessage(), LocalDateTime.now());
        }
    }
}
