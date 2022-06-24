package com.bookmanager.repository
import java.time.LocalDateTime

data class Rental(
    val bookId: Long,
    val userId: Long,
    val rentalDatetime: LocalDateTime,
    val rerurnDeatline: LocalDateTime
)
