/*
 *    Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.sample

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.downloader.PRDownloader
import com.polotika.downloader.R
import com.polotika.downloader.Utils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // dirPath = Utils.getRootDirPath(applicationContext)
    }

/*    fun onClickListenerOne() {
        buttonOne!!.setOnClickListener(View.OnClickListener {
            if (Status.RUNNING == PRDownloader.getStatus(downloadIdOne)) {
                PRDownloader.pause(downloadIdOne)
                return@OnClickListener
            }
            buttonOne!!.isEnabled = false
            progressBarOne!!.isIndeterminate = true
            progressBarOne!!.indeterminateDrawable.setColorFilter(
                Color.BLUE, PorterDuff.Mode.SRC_IN
            )
            if (Status.PAUSED == PRDownloader.getStatus(downloadIdOne)) {
                PRDownloader.resume(downloadIdOne)
                return@OnClickListener
            }
            downloadIdOne = PRDownloader.download(URL1, dirPath, "facebook.apk")
                .build()
                .setOnStartOrResumeListener {
                    progressBarOne!!.isIndeterminate = false
                    buttonOne!!.isEnabled = true
                    buttonOne.setText(R.string.pause)
                    buttonCancelOne!!.isEnabled = true
                }
                .setOnPauseListener { buttonOne.setText(R.string.resume) }
                .setOnCancelListener {
                    buttonOne.setText(R.string.start)
                    buttonCancelOne!!.isEnabled = false
                    progressBarOne!!.progress = 0
                    textViewProgressOne!!.text = ""
                    downloadIdOne = 0
                    progressBarOne!!.isIndeterminate = false
                }
                .setOnProgressListener { progress ->
                    val progressPercent = progress.currentBytes * 100 / progress.totalBytes
                    progressBarOne!!.progress = progressPercent.toInt()
                    textViewProgressOne.setText(
                        Utils.getProgressDisplayLine(
                            progress.currentBytes,
                            progress.totalBytes
                        )
                    )
                    progressBarOne!!.isIndeterminate = false
                }
                .start(object : OnDownloadListener {
                    override fun onDownloadComplete() {
                        buttonOne!!.isEnabled = false
                        buttonCancelOne!!.isEnabled = false
                        buttonOne.setText(R.string.completed)
                    }

                    override fun onError(error: Error) {
                        buttonOne.setText(R.string.start)
                        Toast.makeText(
                            applicationContext,
                            getString(R.string.some_error_occurred) + " " + "1",
                            Toast.LENGTH_SHORT
                        ).show()
                        textViewProgressOne!!.text = ""
                        progressBarOne!!.progress = 0
                        downloadIdOne = 0
                        buttonCancelOne!!.isEnabled = false
                        progressBarOne!!.isIndeterminate = false
                        buttonOne!!.isEnabled = true
                    }
                })
        })
        buttonCancelOne!!.setOnClickListener { PRDownloader.cancel(downloadIdOne) }
    }*/

}