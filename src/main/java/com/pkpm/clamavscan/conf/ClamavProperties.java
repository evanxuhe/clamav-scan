package com.pkpm.clamavscan.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * Created by xuhe
 * Date:2019/1/30
 * Time:21:29
 */
@Configuration
@ConfigurationProperties(prefix = "clamav")
public class ClamavProperties {

    private String hostName;
    private Integer port;
    private Integer timeout;


    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
