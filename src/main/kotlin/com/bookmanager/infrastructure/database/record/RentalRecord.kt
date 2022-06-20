/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.bookmanager.infrastructure.database.record

import java.time.LocalDateTime

data class RentalRecord(
    var bookId: Long? = null,
    var userId: String? = null,
    var rentalDatetime: String? = null,
    var returnDeadline: LocalDateTime? = null
)