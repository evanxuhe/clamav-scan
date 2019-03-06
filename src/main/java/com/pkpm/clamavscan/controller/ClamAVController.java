package com.pkpm.clamavscan.controller;

import fi.solita.clamav.ClamAVClient;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Description:
 * Created by xuhe
 * Date:2019/1/30
 * Time:21:51
 */
@RestController
@RequestMapping(value = "/scan")
public class ClamAVController {

    @Resource
    private ClamAVClient clamAVClient;

    /**
     * 返回clamd的状态
     *
     * @return Clamd status.
     */
    @RequestMapping("/")
    public String ping() throws IOException {
        return "Clamd responding: " + clamAVClient.ping() + "\n";
    }

    /**
     * 传入MultipartFile文件查杀
     *
     * @return Clamd scan result
     */
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public @ResponseBody
    String scanFile(@RequestParam("file") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            byte[] reply = clamAVClient.scan(file.getInputStream());
            return new String(reply, StandardCharsets.US_ASCII);
        } else throw new IllegalArgumentException("empty file");
    }


    @RequestMapping(value = "/stream", method = RequestMethod.POST)
    public @ResponseBody
    String scanStream(@RequestBody byte[] body) throws IOException {

        if (null != body) {
            byte[] reply = clamAVClient.scan(body);
            return new String(reply, StandardCharsets.US_ASCII);
        } else throw new IllegalArgumentException("empty file");
    }


}
