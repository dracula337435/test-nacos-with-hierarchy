package io.dracula.test.nacos.hierarchy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author dk
 */
public class BootStrap {

    public static void main(String[] args){
        AnnotationConfigApplicationContext cac = new AnnotationConfigApplicationContext();
        cac.register(Config.class);
        cac.refresh();
        SomeBean someBean = cac.getBean(SomeBean.class);
        System.out.println(someBean.getA());
    }

}
