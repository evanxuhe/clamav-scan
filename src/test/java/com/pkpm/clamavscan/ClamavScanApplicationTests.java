package com.pkpm.clamavscan;

import com.pkpm.clamavscan.conf.ClamavProperties;
import fi.solita.clamav.ClamAVClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClamavScanApplicationTests {
    @Resource
    ClamavProperties clamavProperties;

    @Resource
    ClamAVClient clamAVClient;

    @Test
    public void contextLoads() {
        System.out.println(clamavProperties.getHostName());
    }



    @Test
    public void ping(){
        byte[] reply;
        byte[] input="X5O!P%@AP[4\\PZX54(P^)7CC)7}$EICAR-STANDARD-ANTIVIRUS-TEST-FILE!$H+H*".getBytes();
        try {
            reply = clamAVClient.scan(input);
            System.out.println(new String(reply, StandardCharsets.US_ASCII));
        } catch (Exception e) {
            throw new RuntimeException("Could not scan the input", e);
        }

    }

}

