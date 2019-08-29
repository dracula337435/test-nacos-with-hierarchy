package io.dracula.test.nacos.hierarchy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author dk
 */
@PropertySource("args.properties")
@ComponentScan
@Configuration
public class Config {

}
