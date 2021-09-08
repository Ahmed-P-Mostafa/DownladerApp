package com.polotika.downloader

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.downloader.Error
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import com.downloader.Status
import com.polotika.downloader.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.cancelBtn.setOnClickListener {
            PRDownloader.cancel(0)
        }
        val url = "http://www.sample-videos.com/video/mp4/720/big_buck_bunny_720p_10mb.mp4"
        val url2 = "https://cdn.pixabay.com/index/2021/08/24/12-15-37-929_1440x550.jpg"


        binding.downloadBtn.setOnClickListener {
            if (Status.PAUSED == PRDownloader.getStatus(0)) {
                PRDownloader.pause(0)
                return@setOnClickListener
            } else if (Status.PAUSED == PRDownloader.getStatus(0)) {
                PRDownloader.resume(0)
                return@setOnClickListener
            }

            if (isInternet()){
                Log.d(TAG, "internet connected: ")

                PRDownloader.download(url2, Utils.getRootDirPath(applicationContext), "test video.jpg")
                    .build()
                    .setOnStartOrResumeListener {
                        binding.downloadBtn.text = getString(R.string.pause)

                    }
                    .setOnPauseListener{
                        binding.downloadBtn.text = getString(R.string.resume)



                    }
                    .setOnCancelListener{
                        binding.downloadBtn.text = getString(R.string.start)



                    }
                    .setOnProgressListener {
                        val progressText = Utils.getProgressDisplayLine(it.currentBytes,it.totalBytes)
                        val progressPercentage = (it.currentBytes * 100) / it.totalBytes
                        binding.progressBar.progress = progressPercentage.toInt()
                        binding.remainingTv.text = progressText


                    }
                    .start(object : OnDownloadListener {
                        override fun onDownloadComplete() {
                            binding.remainingTv.text = getString(R.string.download_completed)
                            binding.downloadBtn.text = getString(R.string.start)

                        }

                        override fun onError(error: Error?) {
                            binding.remainingTv.text = getString(R.string.download_failed)
                            Log.e(TAG, "onError: ${error?.serverErrorMessage}")
                            Log.e(TAG, "onError: ${error?.responseCode}")
                            Log.e(TAG, "onError: ${error?.isServerError}")
                            Log.e(TAG, "onError: ${error?.isConnectionError}")

                        }
                    })

            }

        }


    }

    private fun isInternet(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true


    }
}