package io.dracula.test.nacos.hierarchy;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author dk
 */
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "localhost:8849"))
@NacosPropertySource(dataId = "test")
@ComponentScan
@Configuration
public class Config {

}
