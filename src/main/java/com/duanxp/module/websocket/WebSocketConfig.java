package com.duanxp.module.websocket;

import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: WebSocketConfig
 * @Description:
 * @Author duanxp
 * @Date 2020/03/17 14:42
 */
@Configuration
public class WebSocketConfig {


    /**
     *  注入ServerEndpointExporter，
     *  这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
     */
//    @Profile({ "test","dev"})
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        return new ServerEndpointExporter();
//    }

//
//    @Bean
//    public MySpringConfigurator mySpringConfigurator() {
//        return new MySpringConfigurator();
//    }



}
