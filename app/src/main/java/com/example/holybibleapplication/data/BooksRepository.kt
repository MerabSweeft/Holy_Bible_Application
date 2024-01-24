package com.example.holybibleapplication.data

interface BooksRepository {

    suspend fun fetchBooks(): BooksData

    class Base(
        private val booksCloudMapper: BooksCloudMapper,
        private val cloudDataSource: BooksCloudDataSource
    ) : BooksRepository {
        override suspend fun fetchBooks() = try {
            val booksCloudList = cloudDataSource.fetchBooks()
            BooksData.Success(booksCloudMapper.map(booksCloudList))
        } catch (e: Exception) {
            BooksData.Fail(e)
        }
    }
}