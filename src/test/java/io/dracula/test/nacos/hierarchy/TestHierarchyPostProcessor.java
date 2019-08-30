package io.dracula.test.nacos.hierarchy;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 想试验在父子ApplicationContext场景中，父中的PostProcessor会不会处理子中的
 * 经试验，BeanFactoryPostProcessor仅被作用于父，BeanPostProcessor被作用于父和子
 * @author dk
 */
public class TestHierarchyPostProcessor {

    /**
     * @author dk
     */
    public static class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            System.out.println("MyBeanFactoryPostProcessor.postProcessBeanFactory");
            System.out.println("beanFactory = " + beanFactory);
        }

    }

    /**
     * @author dk
     */
    public static class MyBeanPostProcessor implements BeanPostProcessor{

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization");
            System.out.println("bean = " + bean + ", beanName = " + beanName);
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("MyBeanPostProcessor.postProcessAfterInitialization");
            System.out.println("bean = " + bean + ", beanName = " + beanName);
            return bean;
        }
    }

    @Test
    public void test(){
        //
        AnnotationConfigApplicationContext aac = new AnnotationConfigApplicationContext();
        aac.register(MyBeanFactoryPostProcessor.class, MyBeanPostProcessor.class, SomeBean.class);
        aac.refresh();
        SomeBean someBean = aac.getBean(SomeBean.class);
        System.out.println("parent: "+someBean.getA());
        //
        AnnotationConfigApplicationContext aacChild = new AnnotationConfigApplicationContext();
        aacChild.setParent(aac);
        aacChild.register(SomeBean.class);
        aacChild.refresh();
        SomeBean someBeanInChild = aacChild.getBean(SomeBean.class);
        System.out.println("child: "+someBeanInChild.getA());
    }

}
