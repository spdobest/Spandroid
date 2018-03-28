package spandroid.dev.socialNetworking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import spandroid.dev.R
import android.content.pm.PackageManager
import android.util.Base64.NO_WRAP
import android.widget.TextView
import android.provider.SyncStateContract.Helpers.update
import java.lang.invoke.MethodHandles.Lookup.PACKAGE
import android.content.pm.PackageInfo
import android.support.v4.app.FragmentActivity
import android.util.Log
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*


class LinkedInActivity : AppCompatActivity() {

    companion object {
        val TAG: String = "LinkedInActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linked_in)
    }

    fun generateHashkey() {
        try {
            val info = packageManager.getPackageInfo(
                    PACKAGE,
                    PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())

                // info.packageName
//                 setText(Base64.encodeToString(md.digest(),
//                        Base64.NO_WRAP))
            }
        } catch (e: PackageManager.NameNotFoundException) {
            Log.d(TAG, e.message, e)
        } catch (e: NoSuchAlgorithmException) {
            Log.d(TAG, e.message, e)
        }

    }
}
