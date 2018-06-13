package com.junlong0716.module.common

import android.app.Application
import android.content.Context
import android.content.Intent
import android.support.multidex.MultiDex
import com.tencent.tinker.anno.DefaultLifeCycle
import com.tencent.tinker.lib.tinker.TinkerInstaller
import com.tencent.tinker.loader.app.DefaultApplicationLike
import com.tencent.tinker.loader.shareutil.ShareConstants

/**
 *@author: EdsionLi
 *@description:
 *@date: Created in 2018/5/18 下午5:03
 *@modified by:
 */

@DefaultLifeCycle(
        application = "com.junlong0716.module.common.BaseApplication",
        //这里填写包名和你想要生成的Application类名，tinker会自动生成该类
        flags = ShareConstants.TINKER_ENABLE_ALL)
class SampleApplicationLike(application: Application?, tinkerFlags: Int, tinkerLoadVerifyFlag: Boolean, applicationStartElapsedTime: Long, applicationStartMillisTime: Long, tinkerResultIntent: Intent?) : DefaultApplicationLike(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent) {
    override fun onCreate() {
        super.onCreate()
    }

    override fun onBaseContextAttached(base: Context?) {
        super.onBaseContextAttached(base)
        //you must install multiDex whatever tinker is installed!
        MultiDex.install(base)
        TinkerInstaller.install(this)
    }
}