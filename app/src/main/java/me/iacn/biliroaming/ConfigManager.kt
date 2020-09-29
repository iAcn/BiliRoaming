package me.iacn.biliroaming

import android.app.AndroidAppHelper
import android.content.Context
import android.content.SharedPreferences
import de.robv.android.xposed.XSharedPreferences

/**
 * Created by Meolunr on 2020/7/21
 * Email meolunr@gmail.com
 */
class ConfigManager {

    private val xPrefs: XSharedPreferences by lazy { XSharedPreferences(BuildConfig.APPLICATION_ID) }
    private val biliPrefs: SharedPreferences by lazy { AndroidAppHelper.currentApplication().getSharedPreferences("bili_preference", Context.MODE_PRIVATE) }

    companion object {
        private const val KEY_MAIN_FUNC = "main_func"
        private const val KEY_TEENAGERS_MODE_DIALOG = "teenagers_mode_dialog"
        private const val KEY_COMMENT_FLOOR = "comment_floor"
        private const val KEY_BANGUMI_DOWNLOAD = "bangumi_download"
        private const val KEY_CUSTOM_THEME = "custom_theme"
        private const val KEY_CUSTOM_COLOR = "biliroaming_custom_color"
        private const val KEY_APPLET_SHARE = "applet_share"
        private const val KEY_PLAYER_RECOMMEND = "player_recommend"
        private const val KEY_DANMAKU_TEXT_SIZE_SYNC = "danmaku_text_size_sync"

        val instance: ConfigManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            ConfigManager()
        }
    }

    fun enableMainFunc() = xPrefs.getBoolean(KEY_MAIN_FUNC, false)

    fun disableTeenagersModeDialog() = xPrefs.getBoolean(KEY_TEENAGERS_MODE_DIALOG, false)

    fun enableCommentFloor() = xPrefs.getBoolean(KEY_COMMENT_FLOOR, false)

    fun enableBangumiDownload() = xPrefs.getBoolean(KEY_BANGUMI_DOWNLOAD, false)

    fun enableCustomTheme() = xPrefs.getBoolean(KEY_CUSTOM_THEME, false)

    fun getCustomColor(defValue: Int) = biliPrefs.getInt(KEY_CUSTOM_COLOR, defValue)

    fun putCustomColor(value: Int) = biliPrefs.edit().putInt(KEY_CUSTOM_COLOR, value).apply()

    fun disableAppletShare() = xPrefs.getBoolean(KEY_APPLET_SHARE, false)

    fun disablePlayerRecommend() = xPrefs.getBoolean(KEY_PLAYER_RECOMMEND, false)

    fun disableDanmakuTextSizeSync() = xPrefs.getBoolean(KEY_DANMAKU_TEXT_SIZE_SYNC, false)
}