package com.junlong0716.module.common

/**
 * @author: 巴黎没有摩天轮Li
 * @description: 记录各组件的ApplicationImpl实现类路径
 * @date: Created in 下午10:14 2018/3/15
 * @modified by:
 */
object ModuleConfig {
    val MODULESLIST = arrayOf("com.junlong0716.module.a.ModuleMainAApp","com.junlong0716.module.b.ModuleMainBApp")
    fun modulesApplicationInit(app:BaseApplication) {
        for (moduleImpl in ModuleConfig.MODULESLIST) {
            try {
                val clazz = Class.forName(moduleImpl)
                val obj = clazz.newInstance()
                (obj as? ApplicationImpl)?.onCreate(app)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            }
        }
    }
}
