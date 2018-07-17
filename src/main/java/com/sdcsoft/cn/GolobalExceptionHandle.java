package com.sdcsoft.cn;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GolobalExceptionHandle {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,String> method(){
       Map<String,String> map =new HashMap<>();
       map.put("code","500");
       map.put("msg","亲，系统出错了");
        return map;
    }
}
