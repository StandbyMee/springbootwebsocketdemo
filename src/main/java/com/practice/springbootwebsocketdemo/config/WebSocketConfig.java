package com.practice.springbootwebsocketdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * ClassName: WebSocketConfig <br/>
 * Description: WebSocket的配置类<br/>
 * date: 2021/6/23 15:07<br/>
 *
 * @author Administrator<br />
 * @since JDK 1.8
 */

@Configuration
//@Configuration注解 用来定义配置类
@EnableWebSocketMessageBroker
//@EnableWebSocketMessageBroker用于启用WebSocket服务器
//该类实现了WebSocketMessageBrokerConfigurer接口，并实现了其中的方法
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    //注册一个websocket端点，客户端将使用它连接到我们的websocket服务器
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //withSockJS()是用来为不支持websocket的浏览器启用后备选项，使用了SockJS
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    //配置消息代理，将消息从一个客户端路由到另一个客户端
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}
