package com.demo2;

public class TestLambdal {
//静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambdal() {
            System.out.println("i like lambdal2");
        }
    }
    public static void main(String[] args) {
        ILike like=new Like();
        like.lambdal();

        like=new Like2();
        like.lambdal();
//局部内部类
        class Like3 implements ILike{
            @Override
            public void lambdal() {
                System.out.println("i like lambdal3");
            }
        }

        like=new Like3();
        like.lambdal();

        //匿名内部类
        like=new ILike() {
            @Override
            public void lambdal() {
                System.out.println("i like lambdal4");
            }
        };
        like.lambdal();
        //lambdal简化
        like=() ->{
            System.out.println("i like lambdal5");
        };
        like.lambdal();
    }

}

interface ILike{
    void lambdal();
}

class Like implements ILike{
    @Override
    public void lambdal() {
        System.out.println("i like lambdal");
    }
}
