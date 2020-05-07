package com.ykt.ind_ykt.core.config;
import com.ykt.ind_ykt.core.interceptor.SystemInterceptor;
import com.ykt.ind_ykt.core.security.AuthInterceptor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Autor wuzp
 * @Date 2020-02-08 0011
 * @Usage
 */
@Configuration
@Getter
@Setter
public class WebConfig implements WebMvcConfigurer {

    private List<String> allowed_region;
    @Autowired
    private SystemInterceptor systemInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authInterceptor).addPathPatterns("/**").excludePathPatterns(authless_uri);
        registry.addInterceptor(systemInterceptor).addPathPatterns("/**");
    }
}
