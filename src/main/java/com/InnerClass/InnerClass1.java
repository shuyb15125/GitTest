package com.InnerClass;

public class InnerClass1 {
}
class ExtendClass {
    class Inner{}
}

class WithInner extends ExtendClass.Inner {
    public WithInner(ExtendClass extendClass) {
        extendClass.super();
    }
}

