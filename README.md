# 试验nacos

```spring```上下文，父中设置```nacos```的```server-addr```，子中设置```nacos```的```data-id```  
但是这个写法会报错  
简析：  
试验在父子ApplicationContext场景中，父中的PostProcessor会不会处理子中的。经试验，BeanFactoryPostProcessor，BeanPostProcessor仅被作用于父，不被作用于子  
可见关键类```com.alibaba.nacos.spring.core.env.NacosPropertySourcePostProcessor```，其是一个```BeanFactoryPostProcessor```，用于寻找定义好的```@NacosPropertySource```
    
仅有```server-addr```没有```data-id```不会报错