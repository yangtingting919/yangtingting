package com.example.demo.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Description: websocket
 * @Date: 2018年10月15日16:28
 * @Author: XiaoYeYue
 * @Version: 1.0
 */
@Configuration
//@EnableWebSocketMessageBroker
public class WebSocketConfig {

	/**
	 * 首先要注入ServerEndpointExporter，
	 * 这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint。
	 * 要注意，如果使用独立的servlet容器，
	 * 而不是直接使用springboot的内置容器，
	 * 就不要注入ServerEndpointExporter，
	 * 因为它将由容器自己提供和管理。
	**/
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}

//	@Override extends AbstractWebSocketMessageBrokerConfigurer
//	public void configureMessageBroker(MessageBrokerRegistry config) {
//		config.enableSimpleBroker("/topic");//配置客户端订阅前缀
//		config.setApplicationDestinationPrefixes("/app");//配置客户端发送消息路径前缀
//	}
//
//	@Override
//	public void registerStompEndpoints(StompEndpointRegistry registry) {
//		//"/gs-guide-websocket"是前台连接的端点url
//		registry.addEndpoint("/gs-guide-websocket").setAllowedOrigins("*")
//				.withSockJS();
//	}
}
