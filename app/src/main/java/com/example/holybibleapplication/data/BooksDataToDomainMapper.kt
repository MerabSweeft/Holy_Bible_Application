package com.example.holybibleapplication.data

import com.example.holybibleapplication.core.Abstract
import com.example.holybibleapplication.core.Book
import com.example.holybibleapplication.domain.BookDomain

interface BooksDataToDomainMapper : Abstract.Mapper {

    fun map(books: List<Book>): BookDomain

    fun map(exception: Exception): BookDomain

    /*  class Base : BooksDataToDomainMapper {
          override fun map(books: List<BooksApiModel>): BookDomain = BookDomain.Success(books)


          override fun map(exception: Exception): BookDomain {

              val errorType = when (exception) {
                  is UnknownHostException -> 0
                  is HttpException -> 1
                  else -> 2
              }
              return BookDomain.Fail(errorType)
          }


      }*/
}