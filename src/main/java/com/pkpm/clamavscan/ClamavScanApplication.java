package com.pkpm.clamavscan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 基于clamAV杀毒引擎的web应用
 *
 * @author xuhe
 */
@SpringBootApplication
public class ClamavScanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClamavScanApplication.class, args);
    }

}

