package com.example.holybibleapplication.data.net

import com.example.holybibleapplication.core.Abstract
import com.example.holybibleapplication.core.Book

data class BooksApiModel(
    val genre: Genre,
    val id: Int,
    val name: String,
    val testament: String
) : Abstract.Object<Book, BookServerToDataMapper>() {
    override fun map(mapper: BookServerToDataMapper) = mapper.map(id, name)

}