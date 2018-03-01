package com.leone.chapter.autoconfigure.quartz;

import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.transaction.PlatformTransactionManager;

import java.io.IOException;

/**
 * quartz springboot test
 * leone
 * 2017.10.10
 */

@Configuration
@ConditionalOnClass({JobFactory.class, PlatformTransactionManager.class})
//@ConditionalOnProperty(name = "leone.quartz.enabled")
public class QuartzAutoConfiguration implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext context) {
		this.applicationContext = applicationContext;
	}

	@Bean
	public JobFactory jobFactory(ApplicationContext applicationContext) {
		return new AutowiringSpringBeanJobFactory(applicationContext);
	}

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory) throws IOException {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setOverwriteExistingJobs(true);
		factory.setJobFactory(jobFactory);
		String[] beanNames = applicationContext.getBeanNamesForType(Trigger.class);
		if (beanNames.length > 0) {
			for (int i = 0; i < beanNames.length; i++) {
				Object trigger = applicationContext.getBean(beanNames[i]);
				factory.setTriggers((Trigger) trigger);
			}
		}
		return factory;
	}

	@Bean
	public JobDetailFactoryBean[] sampleJobDetail() {
		String[] beanNames = applicationContext.getBeanNamesForType(SampleJob.class);
		if (beanNames.length > 0) {
			JobDetailFactoryBean[] jobDetailFactoryBeans = new JobDetailFactoryBean[beanNames.length];
			for (int i = 0; i < beanNames.length; i++) {
				Object job = applicationContext.getBean(beanNames[i]);
				jobDetailFactoryBeans[i] = createJobDetail(job.getClass());
			}
			return jobDetailFactoryBeans;
		} else {
			return null;
		}
	}


	@Bean
	public SimpleTriggerFactoryBean[] sampleJobTrigger() {
		String[] beanNames = applicationContext.getBeanNamesForType(JobDetail.class);
		if (beanNames.length > 0) {
			SimpleTriggerFactoryBean[] simpleTriggerFactoryBeans = new SimpleTriggerFactoryBean[beanNames.length];
			for (int i = 0; i < beanNames.length; i++) {
				Object jobetail = applicationContext.getBean(beanNames[i]);
				simpleTriggerFactoryBeans[i] = createTrigger((JobDetail) jobetail);
			}
			return simpleTriggerFactoryBeans;
		} else {
			return null;
		}
	}

	private static JobDetailFactoryBean createJobDetail(Class jobClass) {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
		factoryBean.setJobClass(jobClass);
		factoryBean.setDurability(true);
		return factoryBean;
	}

	private static SimpleTriggerFactoryBean createTrigger(JobDetail jobDetail) {
		SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
		factoryBean.setJobDetail(jobDetail);
		factoryBean.setStartDelay(0L);
		factoryBean.setRepeatInterval(2000L);
		factoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT);
		return factoryBean;
	}


	public class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory {

		private AutowireCapableBeanFactory beanFactory;

		public AutowiringSpringBeanJobFactory(ApplicationContext applicationContext) {
			this.beanFactory = applicationContext.getAutowireCapableBeanFactory();
		}

		@Override
		protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
			final Object job = super.createJobInstance(bundle);
			beanFactory.autowireBean(job);
			return job;
		}
	}
}
