package com.dqpi.algo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mountain
 * @date 2020/10/16
 */
@Configuration
@ConfigurationProperties(prefix = "canvas")
@Getter
@Setter
public class CanvasConfig {
    private int width;
    private int height;
    private int delay;
}
