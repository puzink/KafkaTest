package org.example.configs

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaTopicConfig {

    @Bean
    fun topic3(): NewTopic {
        return TopicBuilder.name("topic-3").build()
    }

    @Bean
    fun topic4(): NewTopic {
        return TopicBuilder.name("topic-4").partitions(3).build()
    }
}