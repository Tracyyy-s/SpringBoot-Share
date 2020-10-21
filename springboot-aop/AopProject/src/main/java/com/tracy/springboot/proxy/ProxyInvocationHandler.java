package com.tracy.springboot.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Tracy
 * @date 2020/10/5 13:22
 */
public class ProxyInvocationHandler implements InvocationHandler {

    //需要被代理的对象
    private Object target;

    private final Logger logger = LoggerFactory.getLogger(ProxyInvocationHandler.class);

    /**
     * 设置被代理对象
     * @param target
     */
    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * 获得代理实例
     * @return
     */
    public Object getProxy() {
        //通过代理对象的接口类型创建一个代理实例
        //该实例可以调用代理对象实现接口的方法
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    /**
     * 动态代理全流程
     * @param proxy
     * @param method
     * @param args
     * @return
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        Object result = null;
        try {
            logger.info("=====动态代理开始======");
            //通过反射调用实例的目标方法
            //target指定代理对象，args指定执行方法的参数
            result = method.invoke(target, args);
            logger.info("=====动态代理正常返回======");
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
            logger.error("=====动态代理发现异常======");
        } finally {
            logger.info("=====动态代理结束=======");
        }

        return result;
    }
}
