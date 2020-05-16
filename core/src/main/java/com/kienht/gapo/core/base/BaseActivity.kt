package com.kienht.gapo.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @author kienht
 * @company OICSoft
 * @since 14/05/2020
 */
abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {

    abstract val layoutResource: Int

    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResource)
        binding.lifecycleOwner = this
    }
}