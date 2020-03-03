//package com.duanxp.module.hello;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.hamcrest.Matchers.equalTo;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * @Version
// * @Author dxp
// * @Date 2019/7/30
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@SpringBootApplication
//public class TestHello {
//
//    private MockMvc mvc;
//
//    public void setUp() throws Exception{
//        System.out.println(" before ...");
//        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
//    }
//
//
//    @Test
//    public  void hello() throws Exception {
//      mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string(equalTo("Hello world")));
//    }
//
//
//}
