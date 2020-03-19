package com.duanxp.module.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @Version
 * @Author dxp
 * @Date 2019/7/31 0031
 */
@Component("my1")
public class MyHealthIndicator implements HealthIndicator {
    private static final String VERSION = "v1.0.0";

    @Override
    public Health health() {
        int code = 0;
        if (code != 0) {
            Health.down().withDetail("code", code).withDetail("version", VERSION).build();
        }
        return Health.up().withDetail("code", code).withDetail("version", VERSION).up().build();
    }
}