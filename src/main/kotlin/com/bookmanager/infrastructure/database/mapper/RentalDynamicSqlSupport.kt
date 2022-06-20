/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.bookmanager.infrastructure.database.mapper

import java.sql.JDBCType
import java.time.LocalDateTime
import org.mybatis.dynamic.sql.SqlTable

object RentalDynamicSqlSupport {
    object Rental : SqlTable("rental") {
        val bookId = column<Long>("book_id", JDBCType.BIGINT)

        val userId = column<String>("user_id", JDBCType.VARCHAR)

        val rentalDatetime = column<String>("rental_datetime", JDBCType.VARCHAR)

        val returnDeadline = column<LocalDateTime>("return_deadline", JDBCType.TIMESTAMP)
    }
}