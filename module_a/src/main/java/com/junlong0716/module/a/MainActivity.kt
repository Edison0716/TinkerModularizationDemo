package com.junlong0716.module.a

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.tbruyelle.rxpermissions2.RxPermissions
import com.tencent.tinker.lib.tinker.TinkerInstaller
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rxPermissions = RxPermissions(this)
        rxPermissions.request(WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE).subscribe { it ->
            if (it) {

            }
        }
    }

    fun turn(view: View) {
        ARouter.getInstance().build("/module_b/MainBActivity").navigation(this)
    }

    fun fixBug(view: View) {
        TinkerInstaller.onReceiveUpgradePatch(application.applicationContext, Environment.getExternalStorageDirectory().absolutePath + File.separator + "fix.patch")
    }
}
