package com.deniz.cmpbookworm.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.deniz.cmpbookworm.book.data.database.DatabaseFactory
import com.deniz.cmpbookworm.book.data.database.FavoriteBookDatabase
import com.deniz.cmpbookworm.book.data.network.KtorRemoteBookDataSource
import com.deniz.cmpbookworm.book.data.network.RemoteBookDataSource
import com.deniz.cmpbookworm.book.data.repository.DefaultBookRepository
import com.deniz.cmpbookworm.book.domain.BookRepository
import com.deniz.cmpbookworm.book.presentation.SelectedBookViewModel
import com.deniz.cmpbookworm.book.presentation.book_detail.BookDetailViewModel
import com.deniz.cmpbookworm.book.presentation.book_list.BookListViewModel
import com.deniz.cmpbookworm.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookListViewModel)
    viewModelOf(::BookDetailViewModel)
    viewModelOf(::SelectedBookViewModel)
}