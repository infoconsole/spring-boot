package com.leone.chapter.profiles;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

public class MyTestBeanRegistrar implements ImportBeanDefinitionRegistrar{
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata
				.getAnnotationAttributes(EnableMyTestBeanConfig.class.getName()));
		String[] namespaces = attributes.getStringArray("value");
		int order = attributes.getNumber("order");
//		PropertySourcesProcessor.addNamespaces(Lists.newArrayList(namespaces), order);
//
//		BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry, PropertySourcesProcessor.class.getName(),
//				PropertySourcesProcessor.class);
	}
}
