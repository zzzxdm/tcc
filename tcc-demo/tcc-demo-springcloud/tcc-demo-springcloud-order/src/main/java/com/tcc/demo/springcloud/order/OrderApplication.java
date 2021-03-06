/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tcc.demo.springcloud.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

import com.tcc.core.utils.SpringApplicationHolder;

/**
 * SpringCloudTccOrderApplication.
 * 
 * @author xuyi
 */
//TODO： 扫描的包过多
@SpringBootApplication(scanBasePackages = { "com.tcc.core", "com.tcc.springcloud", "com.tcc.spring.boot.starter",
		"com.tcc.demo.springcloud.order" }, exclude = { MongoAutoConfiguration.class,
				MongoDataAutoConfiguration.class })
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.tcc.demo.springcloud.order.domain.mapper")
public class OrderApplication implements ApplicationContextAware {

	/**
	 * main.
	 *
	 * @param args
	 *            args
	 */
	public static void main(final String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringApplicationHolder.getInstance().setAppCtx((ConfigurableApplicationContext) applicationContext);
	}
}
