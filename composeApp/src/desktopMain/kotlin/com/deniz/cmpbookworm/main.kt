package com.deniz.cmpbookworm

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.deniz.cmpbookworm.app.App
import com.deniz.cmpbookworm.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CMP-Bookpedia",
        ) {
            App()
        }
    }
}