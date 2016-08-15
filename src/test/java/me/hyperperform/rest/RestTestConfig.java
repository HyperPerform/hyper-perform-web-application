package me.hyperperform.rest;

import me.hyperperform.QueueConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rohan on 2016/07/26.
 */

@Configuration
public class RestTestConfig
{
    @Bean
    public QueueConnection queueConnection()
    {
        return new QueueConnection();
    }
}
