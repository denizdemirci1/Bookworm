package com.deniz.cmpbookworm.book.presentation.book_detail

import com.deniz.cmpbookworm.book.domain.Book


sealed interface BookDetailAction {
    data object OnBackClick: BookDetailAction
    data object OnFavoriteClick: BookDetailAction
    data class OnSelectedBookChange(val book: Book): BookDetailAction
}