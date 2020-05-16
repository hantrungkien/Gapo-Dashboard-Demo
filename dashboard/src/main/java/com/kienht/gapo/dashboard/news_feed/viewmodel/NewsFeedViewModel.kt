package com.kienht.gapo.dashboard.news_feed.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kienht.gapo.core.utils.TAG
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
class NewsFeedViewModel @Inject constructor() : ViewModel() {

    var viewmodel = 0

    init {
        viewmodel += 1
        Log.e(TAG, "init = $viewmodel")
    }

    override fun onCleared() {
        super.onCleared()
        Log.e(TAG, "onCleared")
    }

}