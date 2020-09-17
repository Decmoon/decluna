package com.decmoon.decluna.config;

import com.decmoon.shortcut.core.config.ShortCutAspect;
import com.decmoon.shortcut.core.log.Console;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DecLunaAspect extends ShortCutAspect {

    {
        Console.warn("The aspect service of Decluna is started");
    }

    @Override
    @Pointcut("execution(* com.decmoon.decluna.service.page.*.*(..))")
    public void pointcut() {
    }


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        return doReturn(() -> joinPoint.proceed());
    }

}
