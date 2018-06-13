package com.junlong0716.module.a

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun turn(view: View) {
        ARouter.getInstance().build("/module_b/MainBActivity").navigation(this)
    }
}
