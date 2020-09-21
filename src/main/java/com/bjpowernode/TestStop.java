package com.bjpowernode;

public class TestStop implements Runnable{
    private boolean flag=true;
    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println("run.....Thread"+i++);
        }
    }


    public void stop(){
        this.flag=false;
        System.out.println("线程该停止了");
    }

    public static void main(String[] args) {
        TestStop testStop=new TestStop();
        new Thread(testStop).start();
        for(int i=0;i<30000;i++){
            System.out.println("main "+i);
            if (i==5000){
                testStop.stop();
                System.out.println("线程500到了");

            }
        }
    }
}
