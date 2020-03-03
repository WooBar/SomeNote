package com.duanxp.module.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Version
 * @Author dxp
 * @Date 2019/8/19 0019
 */
@RestController
public class WebfluxController {


    @GetMapping("/webflux")
    public Mono<String> hello() {
        return Mono.just("Welcome to reactive world ~");
    }

}
