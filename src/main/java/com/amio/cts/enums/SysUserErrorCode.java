package com.amio.cts.enums;

/**
 * sysUser错误码及错误信息
 *
 * @author : zhenfeng.liu
 * @date : 2018/9/4 17:24
 */
public enum SysUserErrorCode {
    /**
     * 用户名已存在
     */
    USERNAME_EXISTS("U1001", "username is already exist."),
    /**
     * 用户名长度错误,至少为6位,最多为32位
     */
    USERNAME_LENGTH_ERROR("U1002", "username length error: at least 6 characters and up to 32 characters."),
    /**
     * 密码复杂度错误,至少为6位,且包含字母、数字、符号
     */
    PASSWORD_COMPLEXITY_ERROR("U1003", "password complexity error: it must be at least 6 characters and have " +
            "letters/numbers/special character."),
    /**
     * 密码长度错误,至少为6位,最多为32位
     */
    PASSWORD_LENGTH_ERROR("U1003", "password length error: at least 6 characters and up to 32 characters.");

    /**
     * 错误码
     */
    private String code;
    /**
     * 错误信息
     */
    private String msg;

    SysUserErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
