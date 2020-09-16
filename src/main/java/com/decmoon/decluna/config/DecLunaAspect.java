package com.decmoon.decluna.config;

import com.decmoon.shortcut.core.log.Console;
import com.decmoon.shortcut.exception.ShortCutException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
//@Component
@Deprecated
public class DecLunaAspect  {
    {
        Console.warn("DecLuna aspect");
    }

    @Pointcut("execution(* com.decmoon.decluna.service.*.*.*(..))")
    public void pointcut() {
    }



        @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (ShortCutException e) {
            e.printStackTrace();
            e.shutdown();
        }
        return null;
    }
}
