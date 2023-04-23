package com.sachet.libraryeventsconsumer.repository

import com.sachet.libraryeventsconsumer.entity.LibraryEvent
import org.springframework.data.repository.CrudRepository

interface LibraryEventRepository: CrudRepository<LibraryEvent, String> {
}