package com.ykt.ind_ykt.core;

import com.ykt.ind_ykt.core.annotation.Module;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ModuleLogger {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @AfterThrowing(value = "execution(* com.ykt.ind_ykt.service.impl.*.*(..)) && @annotation(mod))",throwing = "ex")
    public void exception(JoinPoint point, Module mod, Throwable ex) {
        logger.error("异常的模块:"+mod.value());
        logger.error("异常方法："+point.getTarget().getClass().getName()+"."+point.getSignature().getName());
        logger.error("异常的行："+ex.getStackTrace()[0].getLineNumber());
        logger.error("异常类型："+ex.getClass().getName());
        logger.error("异常信息："+ex.getMessage());
    }

    @Before(value = "execution(* com.ykt.ind_ykt.service.impl.*.*(..)) && @annotation(mod))")
    public void methodMonitor(JoinPoint point, Module mod){
        Class clazz=point.getTarget().getClass();
        Module clz=(Module)clazz.getAnnotation(Module.class);
        String clzAno = clz==null?clazz.getName():clz.value();
        logger.info(clzAno+"-"+mod.value()+":"+point.getTarget().getClass().getName()+"."+point.getSignature().getName());
    }
}