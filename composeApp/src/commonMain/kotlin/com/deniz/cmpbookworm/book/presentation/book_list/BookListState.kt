package com.deniz.cmpbookworm.book.presentation.book_list

import com.deniz.cmpbookworm.book.domain.Book
import com.deniz.cmpbookworm.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = true,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)
