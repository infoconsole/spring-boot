package com.leone.chapter.profiles;


import com.leone.chapter.profiles.test.VehicleInfoRequestService;
import com.leone.chapter.profiles.test.VehicleInfoRequestServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;


@Configuration
public class WebServiceConfig {

	/**
	 * 注册CxfServlet
	 *
	 * @return
	 */
	@Bean
	public ServletRegistrationBean createCxfServlet() {
		CXFServlet cxfServlet = new CXFServlet();
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(cxfServlet, "/ws/*");

		servletRegistrationBean.setLoadOnStartup(1);
		return servletRegistrationBean;
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	@Bean(name = "vehicleInfoRequestService")
	public VehicleInfoRequestService createApsDataGetService() {
		return new VehicleInfoRequestServiceImpl();
	}


	/**
	 * 物料编码转换发布服务
	 *
	 * @return
	 */
	@Bean
	public Endpoint createEndPointChange(VehicleInfoRequestService vehicleInfoRequestService) {
		EndpointImpl endpoint = new EndpointImpl(springBus(), vehicleInfoRequestService);

		endpoint.publish("/VehicleInfoRequest");
		addGeneralInterceptor(endpoint);

		return endpoint;
	}


	/**
	 * 添加通用日志功能
	 *
	 * @param endpoint
	 */
	private void addGeneralInterceptor(EndpointImpl endpoint) {
		//控制台日志
		endpoint.getInInterceptors().add(new LoggingInInterceptor());
		endpoint.getOutInterceptors().add(new LoggingOutInterceptor());
		

	}


}