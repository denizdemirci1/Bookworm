package com.deniz.cmpbookworm.book.presentation.book_detail

import com.deniz.cmpbookworm.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)
