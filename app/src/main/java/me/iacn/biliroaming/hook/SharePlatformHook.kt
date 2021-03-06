package me.iacn.biliroaming.hook

import android.os.Bundle
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers.findAndHookMethod
import me.iacn.biliroaming.ConfigManager
import me.iacn.biliroaming.logic.AppletShare
import me.iacn.biliroaming.mirror.BiliBiliPackage

/**
 * Created by Meolunr on 2020/8/8
 * Email meolunr@gmail.com
 */
class SharePlatformHook : BaseHook() {

    override fun isEnable() = ConfigManager.instance.disableAppletShare()

    override fun startHook(classLoader: ClassLoader) {
        val biliPackage = BiliBiliPackage.instance
        findAndHookMethod(biliPackage.sharePlatformDispatch, classLoader, biliPackage.shareHandleBundle, String::class.java, Bundle::class.java, object : XC_MethodHook() {
            override fun beforeHookedMethod(param: MethodHookParam) {
                AppletShare.onShare(param.args[0] as String, param.args[1] as Bundle)
            }
        })
    }
}