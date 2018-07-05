package com.zhang.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Create By ZhangSenWei on 2018/7/5
 **/

@Configuration
@EnableSwagger2
//接入swagger必须的注解
public class SwaggerConfig {

    @Bean
    public Docket createApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//生成文档API的定义
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zhang.controller"))//扫描生成文档的包路径
                .paths(PathSelectors.any())
                .build();
    }


    private  ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("SSH构建restful风格的api")//文档标题
                .description("此接口提供接口调用")//文档说明
                .version("1.0.0").build();//版本号
    }

}
