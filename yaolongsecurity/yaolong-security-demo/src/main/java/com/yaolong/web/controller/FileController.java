package com.yaolong.web.controller;

import com.yaolong.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.IOUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * @author yaoLong
 * @date 2019/10/7  17:14
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private String folder ="F:\\SpringSecurity\\springsecurity\\yaolongsecurity\\yaolong-security-demo\\src\\main\\java\\com\\yaolong\\web\\controller";
    @PostMapping
    public FileInfo upload(MultipartFile file) throws Exception {
        System.out.println(file.getName());
        System.out.println(file.getBytes());
        System.out.println(file.getOriginalFilename());


        File localFile = new File(folder, System.currentTimeMillis()+".txt");
        file.transferTo(localFile);

        return  new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletResponse response, HttpServletRequest request) throws Exception {

        InputStream i = new FileInputStream(new File(folder, id+".txt"));
        OutputStream o = response.getOutputStream();

        response.setContentType("application/x-download");
        response.addHeader("Content-Disposition","attachment;filename=test.txt");

        //下载文件
        IOUtils.copy(i, o);
        o.flush();

    }
}
