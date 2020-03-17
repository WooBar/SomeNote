//package com.duanxp.module.webflux;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.reactive.server.WebTestClient;
//
///**
// * @Version
// * @Author dxp
// * @Date 2019/8/19 0019
// */
//@RunWith(SpringRunner.class)
//@WebFluxTest(controllers = WebfluxController.class)
//public class WebfluxTest {
//
//    @Autowired
//    WebTestClient client;
//
//    @Test
//    public void getHello() {
//        client.get().uri("/webflux").exchange().expectStatus().isOk();
//    }
//
//
//
//}
