package com.deniz.cmpbookworm

import androidx.compose.ui.window.ComposeUIViewController
import com.deniz.cmpbookworm.app.App
import com.deniz.cmpbookworm.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }