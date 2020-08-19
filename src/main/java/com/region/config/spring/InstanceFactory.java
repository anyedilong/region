package com.region.config.spring;


import javafx.application.Application;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 托管
 */
public class InstanceFactory implements ApplicationContextAware {

    private static   ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

            this.applicationContext=applicationContext;
    }

    /**
     * 根据实体获取
     * @param t
     * @param <T>
     * @return
     */
    public static  <T> T  getbean(Class<T> t){
         return  applicationContext.getBean(t);
    }

    /**
     * 根据名字获取
     * @param t
     * @return
     */
    public  static Object getbean(String t){
       return applicationContext.getBean(t);

    }
    
    /**
	 * 根据bean类型和beanname获取托管bean
	 * @param beanType
	 * @param beanName
	 * @return
	 */
	public static <T> T getbean(Class<T> beanType, String beanName){
		return applicationContext.getBean(beanName, beanType);
	}
}
