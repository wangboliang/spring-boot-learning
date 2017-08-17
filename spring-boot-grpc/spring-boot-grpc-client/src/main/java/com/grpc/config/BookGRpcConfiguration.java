package com.grpc.config;

import grpc.api.BookServiceGrpc;
import grpc.api.BookServiceGrpc.BookServiceBlockingStub;
import io.grpc.ManagedChannel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * rpc server连接配置
 * </p>
 *
 * @author wangliang
 * @since 2017-07-05
 */

@Configuration
@EnableAutoConfiguration
public class BookGRpcConfiguration {
    @GrpcClient("spring-boot-grpc-server")
    private ManagedChannel channel;

    @Bean
    public BookServiceBlockingStub bookServiceBlockingStub() {
        return BookServiceGrpc.newBlockingStub(channel);
    }

}
