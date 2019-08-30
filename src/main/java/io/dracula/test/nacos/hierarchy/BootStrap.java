package io.dracula.test.nacos.hierarchy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author dk
 */
public class BootStrap {

    public static void main(String[] args){
        //
        AnnotationConfigApplicationContext aac = new AnnotationConfigApplicationContext();
        aac.register(ConfigParent.class, SomeBean.class);
        aac.refresh();
        SomeBean someBean = aac.getBean(SomeBean.class);
        System.out.println("parent: "+someBean.getA());
        //
        AnnotationConfigApplicationContext aacChild = new AnnotationConfigApplicationContext();
        aacChild.setParent(aac);
        aacChild.register(ConfigChild.class, SomeBean.class);
        aacChild.refresh();
        SomeBean someBeanInChild = aacChild.getBean(SomeBean.class);
        System.out.println("child: "+someBeanInChild.getA());
    }

}
