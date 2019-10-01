package com.zca.test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 通过url下载图片
 * @author Altria
 * Date: 30/9/2019 上午 11:12
 */
public class WebDownload {
    public void download(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("URL错误");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("图片下载失败");
        }
    }
}
