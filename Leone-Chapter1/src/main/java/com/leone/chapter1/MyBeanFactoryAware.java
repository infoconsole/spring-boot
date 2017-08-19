package com.leone.chapter1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

@Service
public class MyBeanFactoryAware implements BeanFactoryAware{
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println(beanFactory);
	}
}
