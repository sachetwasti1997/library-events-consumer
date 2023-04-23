package com.sachet.libraryeventsconsumer.consumer

import com.sachet.libraryeventsconsumer.service.LibraryEventService
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class LibraryEventsConsumer(
    val libraryEventService: LibraryEventService
) {

    private val LOGGER = LoggerFactory.getLogger(LibraryEventsConsumer::class.java)

    @KafkaListener(topics = ["library-events"])
    fun onMessage(consumerRecord: ConsumerRecord<String, String>) {
        LOGGER.info("Consumer Record: {}", consumerRecord)
        libraryEventService.processEvent(consumerRecord)
    }

}