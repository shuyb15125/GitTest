package com.InnerClass;

public class Flower {
    class Bud{
        public Bud(){
            System.out.println("Flower.Bud");
        }
    }

    public Flower(){
        System.out.println("new Flower()");
        new Bud();
        test();
    }
    public void test(){
        System.out.println("Flower.test()");
    }
}
class Flower2 extends Flower{
    class Bud{
        public Bud(){
            System.out.println("Flower2.Bud");
        }
    }
    @Override
    public void test(){
        System.out.println("Flower2.test()");
    }

    public static void main(String[] args) {
        new Flower2();
    }
}
