//package com.duanxp.module.httpclient;
//
//
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//
///**
// * Created by TOPFEEL on 2018/1/10.
// */
//@Slf4j
//public class WXUtil {
//
//    public static AuthTokenVo getAuthToken(String code, String appid, String secret){
//        AuthTokenVo vo = null;
//        try {
//            String uri = "https://api.weixin.qq.com/sns/oauth2/access_token?";
//            StringBuffer url = new StringBuffer(uri);
//            url.append("appid=").append(appid);
//            url.append("&secret=").append(secret);
//            url.append("&code=").append(code);
//            url.append("&grant_type=").append("authorization_code");
//            HttpURLConnection conn = HttpClientUtils.CreatePostHttpConnection(url.toString());
//            InputStream input = null;
//            if (conn.getResponseCode() == 200) {
//                input = conn.getInputStream();
//            } else {
//                input = conn.getErrorStream();
//            }
//
//            vo = JSON.parseObject(new String(HttpClientUtil.readInputStream(input),"utf-8"),AuthTokenVo.class);
//        } catch (Exception e) {
//
//        }
//        log.error("======={}",vo);
//        return vo;
//    }
//
//    public static WeChatUserInfoVo getUserInfo(String accessToken, String openid) {
//        WeChatUserInfoVo userInfo = null;
//        try {
//            String uri = "https://api.weixin.qq.com/sns/userinfo?";
//            StringBuffer url = new StringBuffer(uri);
//            url.append("access_token=").append(accessToken);
//            url.append("&openid=").append(openid);
//            HttpURLConnection conn = HttpClientUtil.CreatePostHttpConnection(url.toString());
//            InputStream input = null;
//            if (conn.getResponseCode() == 200) {
//                input = conn.getInputStream();
//            } else {
//                input = conn.getErrorStream();
//            }
//            log.error("======={}",JSON.parseObject(new String(HttpClientUtil.readInputStream(input))));
//            userInfo = JSON.parseObject(new String(HttpClientUtil.readInputStream(input), "utf-8"), WeChatUserInfoVo.class);
//        } catch (Exception e) {
//
//        }
//        log.error("======={}",userInfo);
//        return userInfo;
//    }
//}
