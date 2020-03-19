package com.duanxp;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@ComponentScan(basePackages = "com.*.**")
@EnableAspectJAutoProxy
@MapperScan(basePackages = "com.duanxp.module.*.dao")
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableWebSocket
public class DemoApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// 注意这里要指向原先用main方法执行的Application启动类
		return builder.sources(DemoApplication.class);
	}


	public static void main(String[] args) {
		//        http://patorjk.com/software/taag/#p=display&f=Graffiti&t=
		//关闭 banner
//        SpringApplication app = new SpringApplication(DemoApplication.class);
////        app.setBannerMode(Banner.Mode.OFF);
////        app.run(args);
		SpringApplication.run(DemoApplication.class, args);
	}

}
