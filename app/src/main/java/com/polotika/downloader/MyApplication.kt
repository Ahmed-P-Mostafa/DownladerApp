package com.polotika.downloader

import android.app.Application
import com.downloader.PRDownloader
import com.downloader.PRDownloaderConfig




class MyApplication :Application() {
    override fun onCreate() {
        super.onCreate()
        val config = PRDownloaderConfig.newBuilder()
            .setDatabaseEnabled(true)
            .build()
        PRDownloader.initialize(applicationContext, config)

    }

}