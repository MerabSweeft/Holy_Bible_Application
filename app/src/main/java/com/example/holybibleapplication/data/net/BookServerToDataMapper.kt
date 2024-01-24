package com.example.holybibleapplication.data.net

import com.example.holybibleapplication.core.Abstract
import com.example.holybibleapplication.core.Book

interface BookServerToDataMapper : Abstract.Mapper {

    fun map(id: Int, name: String): Book

    class BookServerToDataMapperImpl : BookServerToDataMapper {
        override fun map(id: Int, name: String): Book = Book(id, name)


    }
}