package com.bjpowernode;

public class TestThread4 implements Runnable{

    //票数
    private int ticketNum=10;

    @Override
    public void run() {
        while(true){
            if(ticketNum<=0){
                break;
            }
            try{
                Thread.sleep(200);
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"--->拿到了第"+ticketNum--+"张票");
        }

    }

    public static void main(String[] args) {
        TestThread4 ticket=new TestThread4();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛党").start();
    }
}
