package com.tracy.springboot;

import com.tracy.springboot.interf.Calculator;
import com.tracy.springboot.interf.impl.CalculatorImpl;
import com.tracy.springboot.proxy.ProxyInvocationHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AopTests {

    /**
     * 动态代理测试
     */
    @Test
    public void test02() {

        CalculatorImpl service = new CalculatorImpl();
        ProxyInvocationHandler handler = new ProxyInvocationHandler();

        //设置被代理的对象
        handler.setTarget(service);

        //获得代理对象
        Calculator proxy = (Calculator) handler.getProxy();

//        proxy.add(1, 1);
        System.out.println("方法的结果是 " + proxy.add(1, 1));

    }


    @Autowired
    CalculatorImpl service;

    @Test
    public void contextLoads() {
        service.add(1, 2);
    }

    @Test
    public void test01() {
        service.div(1, 0);
    }
}
