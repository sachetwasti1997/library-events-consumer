package com.sachet.libraryeventsconsumer.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

@Entity
class Book (
    @Id
    var bookId: String? = null,
    var bookName: String? = null,
    var bookAuthor: String? = null,
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "libraryEventId")
    var libraryEvent: LibraryEvent? = null
)
