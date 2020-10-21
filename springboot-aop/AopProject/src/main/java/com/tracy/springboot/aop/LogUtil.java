package com.tracy.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Tracy
 * @date 2020/10/1 21:54
 */
@Aspect
@Component
public class LogUtil {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 定义切入点表达式
     */
    @Pointcut("execution(public * com.tracy.springboot.interf.impl.CalculatorImpl.*(..))")
    public void pointCut() {
    }

    /**
     * 前置通知，在切面方法之前执行该方法
     * @param joinPoint jointPoint
     */
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("【LogUtil】前置通知====doBefore方法进入了====");

        // 获取方法签名
        Signature signature = joinPoint.getSignature();

        Object[] args = joinPoint.getArgs();

        // 获取切入的类名
        String declaringTypeName = signature.getDeclaringTypeName();

        // 获取即将执行的方法名
        String funcName = signature.getName();
        logger.info("【LogUtil】即将执行方法为: {" + funcName +"}，参数为：" + Arrays.toString(args) + " 属于{" + declaringTypeName +"}");

    }

    /**
     * 在切面方法返回后执行该方法，可以捕获返回对象或者对返回对象进行增强
     * @param joinPoint joinPoint
     * @param result result
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {

        logger.info("【LogUtil】返回通知====AfterReturning方法进入了====");
        Signature signature = joinPoint.getSignature();
        String classMethod = signature.getName();
        logger.info("【LogUtil】方法{" + classMethod + "}正常返回，结果为：{" + result + "}");
    }

    /**
     * 后置通知，在切面方法之后执行该方法
     * @param joinPoint jointPoint
     */
    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {

        logger.info("【LogUtil】后置通知====After方法进入了====");
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        logger.info("【LogUtil】方法{" + method + "}已经执行完");
    }

    /**
     * 在上面定义的切面方法执行抛异常时，执行该方法
     * @param joinPoint jointPoint
     * @param ex ex
     */
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {

        logger.info("【LogUtil】异常通知====AfterThrowing====");
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        // 处理异常的逻辑
        logger.error("【LogUtil】执行方法{" + method + "}出错，异常为：{" + ex + "}");
    }

    //@Around(value = "pointCut()")
    public Object deAround(ProceedingJoinPoint pjp) throws Throwable {

        Signature signature = pjp.getSignature();
        String name = signature.getName();

        Object[] args = pjp.getArgs();

        Object proceed = null;
        try {
            logger.info("【LogUtil】环绕前置通知，执行方法{" + name + "}");
            proceed = pjp.proceed(args);
            logger.info("【LogUtil】环绕返回通知" + name + " 返回结果{" + proceed + "}");
        } catch (Throwable throwable) {
            logger.info("【LogUtil】环绕异常通知" + name + " 异常信息：" + throwable.getMessage());
            throw new Throwable(throwable);
        } finally {
            logger.info("【LogUtil】环绕结束通知" + name);
        }

        return proceed;
    }
}
