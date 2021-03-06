package com.duanxp.module.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @ClassName: SocketTestController
 * @Description:
 * @Author duanxp
 * @Date 2020/03/17 16:33
 */
@RestController
@RequestMapping("socket")
public class SocketTestController {

    @Autowired
    private SocketImpl socket;

    @GetMapping("/{message}")
    public void sendMessage(@PathVariable("message") String message) throws IOException {
        socket.sendMessage("这个是controller 发送的消息："+message);
    }



}
