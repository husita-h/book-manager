package com.bookmanager.repository

interface BookRepository {
    fun findAllWithRental(): List<BookWithRental>
}