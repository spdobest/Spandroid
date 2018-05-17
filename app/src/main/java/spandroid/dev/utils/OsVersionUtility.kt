package spandroid.dev.utils

import android.os.Build

/**
 * Created by root on 5/17/18.
 */
class OsVersionUtility{

    companion object {

        fun isKitkat(): Boolean {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                true
            } else {
                false
            }
        }
        fun isLolipop(): Boolean {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                true
            } else {
                false
            }
        }

        fun isMarshmallow(): Boolean {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                true
            } else {
                false
            }
        }

        fun isNought(): Boolean {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                true
            } else {
                false
            }
        }
        fun isOreo(): Boolean {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                true
            } else {
                false
            }
        }
        fun isPineApple(): Boolean {
            return if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
                true
            } else {
                false
            }
        }
    }

}