package com.ll.framework.ioc;

import com.ll.domain.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.service.TestPostService;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private Map<String, Object> beans = new HashMap<>();
    private String basePackage;
    public void init() {
    }

    public ApplicationContext(String basePackage) {
        this.basePackage = basePackage;
    }

    public <T> T genBean(String beanName) {//스프링에서 관리하는 객체 의미
        Object bean = beans.get(beanName);

        if(bean == null) {
            bean = switch(beanName) {
                case "testPostService" ->  new TestPostService(genBean("testPostRepository"));
                case "testPostRepository" -> new TestPostRepository();
                case "testFacadePostService" -> new TestFacadePostService(genBean("testPostService"), genBean("testPostRepository"));
                default -> null;
            };


        }

        beans.put(beanName, bean);
        return (T) bean;
    }


}
