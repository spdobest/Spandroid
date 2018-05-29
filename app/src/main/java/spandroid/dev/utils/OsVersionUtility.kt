package spandroid.dev.utils

import android.os.Build

/**
 * Created by root on 5/17/18.
 */
class OsVersionUtility {

    companion object {

        fun isKitkat(): Boolean {
            return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
        }

        fun isLolipop(): Boolean {
            return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
        }

        fun isMarshmallow(): Boolean {
            return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
        }

        fun isNought(): Boolean {
            return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
        }

        fun isOreo(): Boolean {
            return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
        }

        fun isPineApple(): Boolean {
            return Build.VERSION.SDK_INT > Build.VERSION_CODES.O
        }
    }

}