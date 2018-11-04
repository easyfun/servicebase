package com.efun.codedata.po;

import com.efun.codedata.enums.CodeApplyEnums.*;
import com.efun.framework.common.enums.Result;
import com.efun.framework.common.enums.UserAgent;

import java.util.Date;

public class CodeApply {
    private String applyId;

    private ApplyType applyType;

    private String businessId;

    private CodeMode codeMode;

    private String code;

    private String ip;

    private UserAgent userAgent;

    private String deviceId;

    private Result result;

    private String failCode;

    private String failReason;

    private Date createTime;

    private Date updateTime;

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public ApplyType getApplyType() {
        return applyType;
    }

    public void setApplyType(ApplyType applyType) {
        this.applyType = applyType;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public CodeMode getCodeMode() {
        return codeMode;
    }

    public void setCodeMode(CodeMode codeMode) {
        this.codeMode = codeMode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(UserAgent userAgent) {
        this.userAgent = userAgent;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getFailCode() {
        return failCode;
    }

    public void setFailCode(String failCode) {
        this.failCode = failCode;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}