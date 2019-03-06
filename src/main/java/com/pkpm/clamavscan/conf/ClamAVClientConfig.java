package com.pkpm.clamavscan.conf;

import fi.solita.clamav.ClamAVClient;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;

/**
 * Description:自定义的配置类
 * Created by xuhe
 * Date:2019/1/30
 * Time:21:41
 */
@Configuration
public class ClamAVClientConfig {

    @Resource
    private ClamavProperties clamavProperties;

    @Bean
    public ClamAVClient clamAVClient(){
        return new ClamAVClient(clamavProperties.getHostName(), clamavProperties.getPort(),clamavProperties.getTimeout());
    }

    /**
     * 文件上传配置 bean的形式
     * @return
     */
//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        //单个文件最大
//        factory.setMaxFileSize(DataSize.ofGigabytes(4)); //KB,MB
//        /// 设置总上传数据总大小
//        factory.setMaxRequestSize(DataSize.ofGigabytes(4));
//        return factory.createMultipartConfig();
//    }


}
