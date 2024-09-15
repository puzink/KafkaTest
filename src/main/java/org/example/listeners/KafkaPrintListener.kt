package org.example.listeners

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.annotation.TopicPartition
import org.springframework.stereotype.Component

@Component
class KafkaPrintListener {

    @KafkaListener(topicPartitions = [TopicPartition(topic = "topic-4", partitions = ["0"])])
    fun listenGroupFoo(record: ConsumerRecord<String, String>) {
        println("Received Message in group foo: ${record.value()} from part - ${record.partition()}")
    }
}