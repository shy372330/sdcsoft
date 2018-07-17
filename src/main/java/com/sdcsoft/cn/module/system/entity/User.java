package com.sdcsoft.cn.module.system.entity;

import java.util.Date;
public class User {
    private  Integer id;
    private Integer orgType;
    private Integer orgId;
    private String  password;
    private String mobile;
    private String  email;
    private String  weiXin;
    private String  qQ;
    private String  realName;
    private Integer  status;
    private String lastLoginDatetime;
    private String mark;
    private Integer isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeiXin() {
        return weiXin;
    }

    public void setWeiXin(String weiXin) {
        this.weiXin = weiXin;
    }

    public String getqQ() {
        return qQ;
    }

    public void setqQ(String qQ) {
        this.qQ = qQ;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLastLoginDatetime() {
        return lastLoginDatetime;
    }

    public void setLastLoginDatetime(String lastLoginDatetime) {
        this.lastLoginDatetime = lastLoginDatetime;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
