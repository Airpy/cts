package com.amio.cts.exceptions;

import com.amio.cts.enums.SysUserErrorCode;

/**
 * 系统用户异常类
 *
 * @author : zhenfeng.liu
 * @date : 2018/9/4 17:24
 */
public class SysUserException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final SysUserErrorCode sysUserErrorCode;

    public SysUserException(SysUserErrorCode sysUserErrorCode) {
        this.sysUserErrorCode = sysUserErrorCode;
    }

    public SysUserErrorCode getSysUserErrorCode() {
        return sysUserErrorCode;
    }
}
