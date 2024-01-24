package com.example.holybibleapplication.domain

import com.example.holybibleapplication.core.Abstract
import com.example.holybibleapplication.data.net.BooksApiModel
import com.example.holybibleapplication.presentation.BookUi

sealed class BookDomain : Abstract.Object<BookUi, Abstract.Mapper.FinalEmpty>() {

    class Success(books: List<BooksApiModel>) : BookDomain() {
        override fun map(mapper: Abstract.Mapper.FinalEmpty): BookUi {
            TODO("Not yet implemented")
        }

    }

    class Fail(errorType: Int) : BookDomain() {
        override fun map(mapper: Abstract.Mapper.FinalEmpty): BookUi {
            TODO("Not yet implemented")
        }

    }

}
