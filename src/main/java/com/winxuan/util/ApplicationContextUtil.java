package com.winxuan.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.dangdang.config.service.GeneralConfigGroup;
import com.dangdang.config.service.observer.IObserver;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(ApplicationContextUtil.applicationContext == null) {
            ApplicationContextUtil.applicationContext = applicationContext;
        }
        System.out.println("---------------------------------------------------------------------");

        System.out.println("---------------------------------------------------------------------");

        System.out.println("---------------me.shijunjie.util.SpringUtil------------------------------------------------------");

        System.out.println("========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象,applicationContext="+ApplicationContextUtil.applicationContext+"========");

        System.out.println("---------------------------------------------------------------------");
    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取 Bean.
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
    
    @PostConstruct
	private void init() {
    	GeneralConfigGroup cg1 = (GeneralConfigGroup) getApplicationContext().getBean("propertyGroup1");
		cg1.register(new IObserver() {

			@Override
			public void notified(String data, String value) {
				getApplicationContext().getBean(RefreshScope.class).refresh("exampleBeanWithSpel");
				
			}
		});
	}
    
}