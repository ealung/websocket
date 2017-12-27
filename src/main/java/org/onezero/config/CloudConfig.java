package org.onezero.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

/**
 * Created by zhangchanglu on 2017/12/12
 * email hzzhangchanglu@corp.netease.com
 *
 * @author zhangchanglu
 */
@Configuration
@EnableWebSocketMessageBroker
public class CloudConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean containerFactoryBean = new ServletServerContainerFactoryBean();
        containerFactoryBean.setMaxTextMessageBufferSize(8192);
        containerFactoryBean.setMaxBinaryMessageBufferSize(8192);
        return containerFactoryBean;
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/cloud")
                .setAllowedOrigins("*")
                .withSockJS()
        ;
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/cloud");
        registry.enableSimpleBroker("/chat", "/topic")
        ;
    }
}
