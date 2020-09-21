package com.bjpowernode.springboot;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class Client {
    public static void main(String[] args){
        BufferedReader br = null;
        PrintWriter pw = null;
        try{
            Socket socket = new Socket("10.0.10.230",9085);
            //获取输入流与输出流
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream(),true);
            //向服务器发送数据
            pw.println("{\n" +
                    "  \"MessageType\": \"Login\",\n" +
                    "  \"UserName\": \"admin\",\n" +
                    "  \"Password\": \"btws@2020\"\n" +
                    "}");
            String s = null;
            while (true){
                s = br.readLine();
                if(s != null){
                    break;
                }
            }
            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                br.close();
                pw.close();
            }catch (Exception e){
            }
        }
    }

}
