package com.bjpowernode;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

//图片下载
public class TestThread2  extends Thread{
    private String url;
    private  String name;
    public TestThread2(String url,String name){
        this.url=url;
        this.name="C:/Users/john/Desktop/新建文件夹/"+name;
    }
    @Override
    public void run() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        TestThread2 t1=new TestThread2("https://m.tuniucdn.com/fb3/s1/2n9c/2ZHNwPkQ7fRCk4KJFvS9ERZNAj4w_w640_h320_c1_t0_q70.jpg","1.jpg");
        TestThread2 t2=new TestThread2("https://m.tuniucdn.com/fb3/s1/2n9c/3sWdVSycYawqhzFZcJHxfsJho3cr_w640_h320_c1_t0_q70.jpg","2.jpg");
        TestThread2 t3=new TestThread2("https://m.tuniucdn.com/fb3/s1/2n9c/3bftXtjwychanbUDpu2SG28x1m9R_w640_h320_c1_t0_q70.jpg","3.jpg");
        t1.start();
        t2.start();
        t3.start();
    }
}

class  WebDownloader{
    public void downloader(String url,String name){
        try{
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");

        }

    }
}
