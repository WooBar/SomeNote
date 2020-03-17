package com.duanxp.module.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

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

    //使用boot内置tomcat时需要注入此bean
        @Profile({ "test"})
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }


    @Bean
    public MySpringConfigurator mySpringConfigurator() {
        return new MySpringConfigurator();
    }



}
