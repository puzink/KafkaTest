package org.example.services

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class KafkaSender(val kafkaTemplate: KafkaTemplate<String, String>) {

    @Scheduled(cron = "0/3 * * * * *")
    fun send() {
        println("Sending message")
        kafkaTemplate.send("topic-4", 0, "key", "test")
            .thenApply {
                println(it.recordMetadata.partition())
                println(it.producerRecord.key())
            }
    }

}