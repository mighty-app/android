package cc.mightyapp.mighty.util

import androidx.appcompat.app.AppCompatDelegate
import androidx.browser.customtabs.CustomTabsIntent.*

private const val LIGHT = "light"
private const val DARK = "dark"
private const val BATTERY = "battery"
private const val DEFAULT = "default"

fun applyTheme(theme: String?) {
    when (theme) {
        LIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        DARK -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        BATTERY -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
        DEFAULT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }
}

@ColorScheme
fun getCustomTabsColorScheme(theme: String?): Int {
    return when (theme) {
        LIGHT -> COLOR_SCHEME_LIGHT
        DARK -> COLOR_SCHEME_DARK
        else -> COLOR_SCHEME_SYSTEM
    }
}
