package com.demo2;

public class TestLambdal2 {
    public static void main(String[] args) {
//        ILove love=(int a)->{
//            System.out.println("i love "+a);
//        };

        ILove love=( a)->{
            System.out.println("i love "+a);
        };



        love.loveing(10);
    }
}
interface ILove{
    void loveing(int a);
}
