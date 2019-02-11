package com.org.graduactionproject;

import org.apache.catalina.filters.CorsFilter;
import org.apache.jasper.tagplugins.jstl.core.Url;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication
//@EnableTransactionManagement
@MapperScan({"com.org.graduactionproject.dao", "com.org.graduactionproject.config"})//(主要作用是扫包)
public class GraduactionprojectApplication {
    public static void main(String[] args) {
        SpringApplication.run(GraduactionprojectApplication.class, args);
    }
//    private CorsConfiguration buildConfig(){
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedMethod("*");
//        return corsConfiguration;
//    }
//    public CorsFilter corsFilter(){
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", buildConfig());
//        return new CorsFilter(source);
//    }
}

