package cn.com.zhirun.ssm0514.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyAspect {

    @Pointcut("execution(* cn.com.zhirun.ssm0514.service..*.*(..))")
    public void myPointCut(){}

    @Before("myPointCut()")
    public void doAccessCheck(){
        System.out.println("前置通知");
    }

    @AfterReturning("myPointCut()")
    public void doAfter(){
        System.out.println("最终通知");
    }

    @After("myPointCut()")
    public void after(){
        System.out.println("后置通知");
    }

    @AfterThrowing("myPointCut()")
    public void doAfterThrow(){
        System.out.println("例外通知");
    }

    @Around("myPointCut()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("进入环绕通知");
        Object object = pjp.proceed();//执行该方法
        System.out.println("退出环绕通知");
        return object;
    }


}
