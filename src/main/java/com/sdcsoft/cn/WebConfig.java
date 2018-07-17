package com.sdcsoft.cn;
import com.sdcsoft.cn.common.interceptor.MyInterceptor;
import com.sdcsoft.cn.common.interceptor.PermissionInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class WebConfig extends WebMvcConfigurerAdapter  {
    /**
     *
     * 自定义拦截器加载
     */
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/login").
                excludePathPatterns("/loginin").excludePathPatterns("/logout").excludePathPatterns("/nopermission").excludePathPatterns("/getVerify").excludePathPatterns("/timeout").excludePathPatterns("/").excludePathPatterns("");
       interceptorRegistry.addInterceptor(new PermissionInterceptor()).addPathPatterns("/**").excludePathPatterns("/login").
              excludePathPatterns("/index").excludePathPatterns("/loginin").excludePathPatterns("/permisson")
              .excludePathPatterns("/logout").excludePathPatterns("/nopermission").
               excludePathPatterns("/getUserName").excludePathPatterns("/getVerify").excludePathPatterns("/enterprise/getUserRoleInfo").excludePathPatterns("/timeout").excludePathPatterns("/").excludePathPatterns("");
    }

}
