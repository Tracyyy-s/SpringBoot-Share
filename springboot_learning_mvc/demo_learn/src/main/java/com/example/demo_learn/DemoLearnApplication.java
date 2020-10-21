package com.example.demo_learn;
/*
spring boot启动类:项目名+Application.class
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * springBoot启动的时候加载主配置类，
 * @SpringBootApplication是一个复合注解
 *
 * 1.@SpringBootConfiguration
 * Spring Boot的配置类；
 * 用于构建bean定义，初始化Spring容器。
 * @SpringBootConfiguration注解中没有定义任何属性信息，
 * 而该注解上有一个注解@Configuration，用于标识配置类。
 * 所以@SpringBootConfiguration注解的功能和@Configuration注解的功能相同，
 * 用于标识配置类。
 * 2.@EnableAutoConfiguration：启动自动配置，
 * 自动载入应用程序所需要的所有默认配置,达到智能的自动配置作用
 * 实现约定大于配置
 * @EnableAutoConfiguration注解上标注了两个注解，
 *      @AutoConfigurationPackage、@Import。
 *          @AutoConfigurationPackage自动配置包
 *          将所有符合条件的@Configuration配置都加载到IoC容器中
 *          @Import注解在SpringIOC一些注解的源码中比较常见，
 *          主要用来给容器导入目标bean。
 * 将类路径下  META-INF/spring.factories 里面配置的所有EnableAutoConfiguration的值加入到了容器中
 * xxxxAutoConfiguration：帮我们给容器中自动配置组件；
 * xxxxProperties:配置类来封装配置文件的内容；
 * 3.@ComponentScan
 * 扫描当前包及其子包下被@Component，@Controller，@Service，@Repository注解标记的类并纳入到spring容器中进行管理。
 * 自动扫描并加载符合条件的组件或bean定义，最终将这些bean定义加载到容器中。
 * 我们可以通过basePackages等属性指定@ComponentScan自动扫描的范围，
 * 如果不指定，则默认Spring框架实现从声明@ComponentScan所在类的package进行扫描，
 * 默认情况下是不指定的，所以SpringBoot的启动类最好放在root package下。
 */
@SpringBootApplication
public class DemoLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoLearnApplication.class, args);
    }

}
