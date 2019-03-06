
package com.pkpm.clamavscan.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * aop日志 记录杀毒耗时
 *
 * @author xuhe
 * @date 2019/3/5
 */

@Aspect
@Component
@Slf4j
public class LogAspect {

    private AtomicInteger streamFileIndex = new AtomicInteger();

    @Pointcut(value = "execution(public * com.pkpm.clamavscan.controller.ClamAVController.scanFile(..))")
    public void scanFile() {
    }

    @Before("scanFile()")
    public void doBefore(JoinPoint joinPoint) {
    }

    @Around("scanFile()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        try {

            Long start = new Date().getTime();
            Object object = joinPoint.proceed();
            Long end = new Date().getTime();

            String filename="";
            MultipartFile file=null;
            if (null!=joinPoint.getArgs()&&joinPoint.getArgs().length>0){
                file = (MultipartFile) joinPoint.getArgs()[0];
            }

            String finalResult = object.toString() + "[耗时]" + (end - start) + "ms";
            log.info("文件[{}]查杀花费[{}ms] 大小[{}]Bytes 结果为[{}]",file.getOriginalFilename(),(end-start),file.getSize(),object);

            return finalResult;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
