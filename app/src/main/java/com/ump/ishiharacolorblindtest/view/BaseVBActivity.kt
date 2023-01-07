package com.ump.ishiharacolorblindtest.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseVBActivity<VB : ViewBinding> : AppCompatActivity() {
    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)

        initView()
    }

    abstract fun getViewBinding(): VB

    abstract fun initView()
}