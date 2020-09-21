package com.demo2;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.concurrent.Callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallable implements Callable<Boolean> {
    private String url;
    private  String name;
    public TestCallable(String url,String name){
        this.url=url;
        this.name="C:/Users/john/Desktop/新建文件夹/"+name;
    }
    @Override
    public Boolean call() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
        return true;
    }

    public static void main(String[] args) {
        try{
            TestCallable t1=new TestCallable("https://m.tuniucdn.com/fb3/s1/2n9c/2ZHNwPkQ7fRCk4KJFvS9ERZNAj4w_w640_h320_c1_t0_q70.jpg","1.jpg");
            TestCallable t2=new TestCallable("https://m.tuniucdn.com/fb3/s1/2n9c/3sWdVSycYawqhzFZcJHxfsJho3cr_w640_h320_c1_t0_q70.jpg","2.jpg");
            TestCallable t3=new TestCallable("https://m.tuniucdn.com/fb3/s1/2n9c/3bftXtjwychanbUDpu2SG28x1m9R_w640_h320_c1_t0_q70.jpg","3.jpg");
            //创建执行服务
            ExecutorService ser= Executors.newFixedThreadPool(3);
            //提交执行
            Future<Boolean> r1=ser.submit(t1);
            Future<Boolean> r2=ser.submit(t2);
            Future<Boolean> r3=ser.submit(t3);
            //获取结果
            boolean rs1=r1.get();
            boolean rs2=r2.get();
            boolean rs3=r3.get();
            //关闭服务
            ser.shutdownNow();
        }catch (Exception e){

        }

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
