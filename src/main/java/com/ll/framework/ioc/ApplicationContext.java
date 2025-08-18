package com.ll.framework.ioc;

public class ApplicationContext {
    private static String basePackage;

    public void init() {
    }

    public ApplicationContext(String basePackage) {
        this.basePackage = basePackage;
    }
}
