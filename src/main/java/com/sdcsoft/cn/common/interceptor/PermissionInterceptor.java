package com.sdcsoft.cn.common.interceptor;

import com.sdcsoft.cn.module.system.entity.Permission;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PermissionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //controller访问的相对路径
        String path=request.getServletPath();
        //取出session中的permission
        List<Permission> permissionList = ( List<Permission>) request.getSession().getAttribute("permissionList");
        for (Permission permission:permissionList){
                if (permission.getUrl()!=null){
                    if (permission.getUrl().equals(path.substring(1))) {
                        return true;
                    }
                }
        }

        response.sendRedirect(request.getContextPath()+"/nopermission");
        return false;

    }
}