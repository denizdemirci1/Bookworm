package com.deniz.cmpbookworm.book.data.network

import com.deniz.cmpbookworm.book.data.dto.BookWorkDto
import com.deniz.cmpbookworm.book.data.dto.SearchResponseDto
import com.deniz.cmpbookworm.core.domain.DataError
import com.deniz.cmpbookworm.core.domain.Result


interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>
}