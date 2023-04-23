package com.sachet.libraryeventsconsumer.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.sachet.libraryeventsconsumer.entity.LibraryEvent
import com.sachet.libraryeventsconsumer.entity.LibraryEventType
import com.sachet.libraryeventsconsumer.repository.LibraryEventRepository
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.stereotype.Service

@Service
class LibraryEventService(
    private val libraryEventRepository: LibraryEventRepository,
    private val objectMapper: ObjectMapper
) {

    fun processEvent(consumerRecord: ConsumerRecord<String, String>) {
        val libraryEvent = objectMapper.readValue(consumerRecord.value(), LibraryEvent::class.java)
        when(libraryEvent.eventType) {
            LibraryEventType.NEW -> {
                save(libraryEvent)
            }
            LibraryEventType.UPDATE -> {

            }
            else -> {

            }
        }
    }

    private fun save(libraryEvent: LibraryEvent) {
        libraryEvent.book?.libraryEvent = libraryEvent
        libraryEventRepository.save(libraryEvent)
    }

}