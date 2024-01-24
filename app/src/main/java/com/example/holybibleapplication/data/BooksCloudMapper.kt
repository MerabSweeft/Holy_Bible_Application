package com.example.holybibleapplication.data

import com.example.holybibleapplication.core.Abstract
import com.example.holybibleapplication.core.Book
import com.example.holybibleapplication.data.net.BookServerToDataMapper
import com.example.holybibleapplication.data.net.BooksApiModel

interface BooksCloudMapper : Abstract.Mapper {

    fun map(cloudList: List<BooksApiModel>): List<Book>


    class BooksCloudMapperImpl(private val bookMapper: BookServerToDataMapper) : BooksCloudMapper {
        override fun map(cloudList: List<BooksApiModel>) = cloudList.map { bookCloud ->
            bookCloud.map(bookMapper)
        }

    }
}