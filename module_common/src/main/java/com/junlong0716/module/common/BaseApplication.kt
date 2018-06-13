package com.junlong0716.module.common

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.Utils
import com.tencent.tinker.loader.app.TinkerApplication
import com.tencent.tinker.loader.shareutil.ShareConstants

/**
 *@author: EdsionLi
 *@description:
 *@date: Created in 2018/6/13 上午11:26
 *@modified by:
 */
open class BaseApplication : TinkerApplication(ShareConstants.TINKER_ENABLE_ALL, "com.junlong0716.module.common.SampleApplicationLike",
        "com.tencent.tinker.loader.TinkerLoader", false) {

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
        initARouter()
        ModuleConfig.modulesApplicationInit(this)
    }

    private fun initARouter() {
        if (AppUtils.isAppDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()    // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}