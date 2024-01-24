package com.example.holybibleapplication.data

import com.example.holybibleapplication.core.Abstract
import com.example.holybibleapplication.core.Book
import com.example.holybibleapplication.data.net.BooksApiModel
import com.example.holybibleapplication.domain.BookDomain


//es aris saerto klasi data laieristvis romelic saqsess an feils abrunebs mosuli datas mixedvit da awvdis mapers domein leieris mimartulebit
sealed class BooksData : Abstract.Object<BookDomain, BooksDataToDomainMapper>() {
    class Success(private val books: List<Book>) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain = mapper.map(books)
    }

    class Fail(private val exception: Exception) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain = mapper.map(exception)
    }

}
