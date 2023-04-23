package com.sachet.libraryeventsconsumer.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import lombok.ToString

@Entity
class LibraryEvent (
    @Id
    var libraryId: String? = null,
    @Enumerated(EnumType.STRING)
    var eventType: LibraryEventType? = null,
    @OneToOne(mappedBy = "libraryEvent", cascade = [CascadeType.ALL])
    @ToString.Exclude
    var book: Book? = null
)