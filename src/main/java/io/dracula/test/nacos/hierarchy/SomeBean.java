package io.dracula.test.nacos.hierarchy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author dk
 */
@Component
public class SomeBean {

    @Value("${a}")
    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
