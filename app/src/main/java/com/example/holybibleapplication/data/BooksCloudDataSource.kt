package com.example.holybibleapplication.data

import com.example.holybibleapplication.data.net.BooksApiModel
import com.example.holybibleapplication.data.net.BooksService

interface BooksCloudDataSource {

    suspend fun fetchBooks(): List<BooksApiModel>

    class Base(private val booksService: BooksService) : BooksCloudDataSource {
        override suspend fun fetchBooks() = booksService.fetchBooks()
    }
}