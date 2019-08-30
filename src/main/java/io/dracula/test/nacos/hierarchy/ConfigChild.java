package io.dracula.test.nacos.hierarchy;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.Configuration;

/**
 * @author dk
 */
@NacosPropertySource(dataId = "test")
@Configuration
public class ConfigChild {

}
