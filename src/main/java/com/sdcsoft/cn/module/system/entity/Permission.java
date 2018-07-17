package com.sdcsoft.cn.module.system.entity;

public class Permission  {
    private  Integer resId;
    private  String resName;
    private  Integer pId;
    private  String url;
    private  String permission;
    private  Integer id;
    private  String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

  //  @Override
    public String toString() {
        return "Permission{" +
                "resId=" + resId +
                ", resName='" + resName + '\'' +
                ", pId=" + pId +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }

   /* @Override
    public boolean implies(org.apache.shiro.authz.Permission permission) {
        return false;
    }*/
}
