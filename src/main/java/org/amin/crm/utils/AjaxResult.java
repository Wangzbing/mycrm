package org.amin.crm.utils;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author Amin
 * @Create 2018-11-29 16:22
 */
public class AjaxResult {
    private Boolean success=true;
    private String msg;
    private Integer errCode;

    public AjaxResult() {
    }

    //成功
    public AjaxResult(String msg) {
        this.msg = msg;
    }

    //失败
    public AjaxResult(String msg, Integer errCode) {
        this.success=false;
        this.msg = msg;
        this.errCode = errCode;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
