package spandroid.dev.socialNetworking

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.linkedin.platform.APIHelper
import com.linkedin.platform.DeepLinkHelper
import com.linkedin.platform.LISession
import com.linkedin.platform.LISessionManager
import com.linkedin.platform.errors.LIApiError
import com.linkedin.platform.errors.LIAuthError
import com.linkedin.platform.errors.LIDeepLinkError
import com.linkedin.platform.listeners.ApiListener
import com.linkedin.platform.listeners.ApiResponse
import com.linkedin.platform.listeners.AuthListener
import com.linkedin.platform.listeners.DeepLinkListener
import com.linkedin.platform.utils.Scope
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_linked_in.*
import org.json.JSONObject
import spandroid.dev.R


class LinkedInActivity : AppCompatActivity() {


    lateinit var thisActivity: Activity
    val host = "api.linkedin.com"
    lateinit var topCardUrl: String

    companion object {
        val TAG: String = "LinkedInActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linked_in)

        thisActivity = this

        topCardUrl = "https://" + host + "/v1/people/~:(first-name,last-name,email-address,formatted-name,phone-numbers,public-profile-url,picture-url,picture-urls::(original))"


        /*LISessionManager.getInstance(applicationContext).init(thisActivity, buildScope(), object : AuthListener {
            override fun onAuthSuccess() {
                // Authentication was successful.  You can now do
                // other calls with the SDK.
            }

            override fun onAuthError(error: LIAuthError) {
                // Handle authentication errors
            }
        }, true)
*/

        val url = "https://api.linkedin.com/v1/people/~"

        val apiHelper = APIHelper.getInstance(applicationContext)
        apiHelper.getRequest(this, url, object : ApiListener {
            override fun onApiSuccess(apiResponse: ApiResponse) {
                // Success!
            }

            override fun onApiError(liApiError: LIApiError) {
                // Error making GET request!
            }
        })


        btnLogin.setOnClickListener(View.OnClickListener { setAccessToken() })
        btnLogout.setOnClickListener(View.OnClickListener { logout() })
        btnShare.setOnClickListener(View.OnClickListener { shareMessage() })

    }


    // Build the list of member permissions our LinkedIn session requires
    private fun buildScope(): Scope {
        return Scope.build(Scope.R_BASICPROFILE, Scope.R_EMAILADDRESS, Scope.W_SHARE)
    }


    private fun buildScopeShare(): Scope {
        return Scope.build(Scope.W_SHARE)
    }

    /**
     * SHARE CONTENT IN LINKED IN
     */
    fun shareMessage() {


        var url: String = "https://api.linkedin.com/v1/people/~/shares"

        var body: JSONObject = JSONObject("{" +
                "\"comment\": \"Sample share\"," +
                "\"visibility\": { \"code\": \"anyone\" }," +
                "\"content\": { " +
                "\"title\": \"Sample share\"," +
                "\"description\": \"Testing the mobile SDK call wrapper!\"," +
                "\"submitted-url\": \"http://www.example.com/\"," +
                "\"submitted-image-url\": \"http://www.example.com/pic.jpg\"" +
                "}" +
                "}")

        var apiHelper: APIHelper = APIHelper.getInstance(applicationContext)
        apiHelper.postRequest(this, url, body, object : ApiListener {
            override fun onApiSuccess(apiResponse: ApiResponse) {
                println("apiResponse${apiResponse}")
                // Success!
            }

            override fun onApiError(liApiError: LIApiError) {
                // Error making GET request!
                println("liApiError${liApiError}")
            }
        })

    }

    fun buildShareMessage(comment: String, title: String, descriptions: String, linkUrl: String, imageUrl: String): String {
        return "{ \n" +
                " \"comment\":\"" + comment + "\"," +
                " \"visibility\":{ " +
                " \"code\":\"anyone\"" +
                " }," +
                " \"content\":{ " +
                " \"title\":\"" + title + "\"," +
                " \"description\":\"" + descriptions + "\"," +
                " \"submitted-url\":\"" + linkUrl + "\"," +
                " \"submitted-image-url\":\"" + imageUrl + "\"" +
                " }" +
                "}"
    }

    fun openUserProfile() {
        val deepLinkHelper = DeepLinkHelper.getInstance()
        deepLinkHelper.openCurrentProfile(thisActivity, object : DeepLinkListener {
            override fun onDeepLinkSuccess() {}
            override fun onDeepLinkError(error: LIDeepLinkError) {}
        })
    }

    fun logout() {
        LISessionManager.getInstance(applicationContext).clearSession()
    }

    fun isLogin(): Boolean {
        var sessionManager: LISessionManager = LISessionManager.getInstance(applicationContext)
        var session: LISession = sessionManager.session
        var accessTokenValid: Boolean = session.isValid
        return accessTokenValid
    }

    fun loginLinkedin() {


        LISessionManager.getInstance(applicationContext).init(thisActivity, buildScope(), object : AuthListener {
            override fun onAuthSuccess() {
                // Authentication was successful.  You can now do
                // other calls with the SDK.

                val apiHelper = APIHelper.getInstance(applicationContext)
                apiHelper.getRequest(thisActivity, topCardUrl, object : ApiListener {
                    override fun onApiSuccess(s: ApiResponse) {
                        getDetails(s)
                    }

                    override fun onApiError(error: LIApiError) {}
                })

            }

            override fun onAuthError(error: LIAuthError) {
                // Handle authentication errors
            }
        }, true)
    }


    fun getDetails(s: ApiResponse) {

        Log.e("TAG", "Profile json" + s.responseDataAsJson)
        Log.e("TAG", "Profile String" + s.responseDataAsString)

        try {
            Log.e("TAG", "Profile emailAddress" + s.responseDataAsJson.get("emailAddress").toString())
            Log.e("TAG", "Profile formattedName" + s.responseDataAsJson.get("formattedName").toString())

            tvName.text = s.responseDataAsJson.get("emailAddress").toString()
            LastName.text = s.responseDataAsJson.get("formattedName").toString()

            Picasso.with(thisActivity).load(s.responseDataAsJson.getString("pictureUrl"))
                    .into(imageViewProfile)

        } catch (e: Exception) {

        }
    }

    fun setAccessToken() {
        val sessionManager = LISessionManager.getInstance(applicationContext)
        val session = sessionManager.session

        val accessTokenValid = session.isValid

        var respon = ""

        if (accessTokenValid) {
            val url = "https://api.linkedin.com/v1/people/~?format=json"
            //String url = "https://api.linkedin.com/v1/people/~:(id,first-name,last-name,picture-url)";
            val apiHelper = APIHelper.getInstance(applicationContext)
            apiHelper.getRequest(thisActivity, url, object : ApiListener {
                override fun onApiSuccess(apiResponse: ApiResponse) {
                    respon = apiResponse.toString()
                    Log.e("Response ", respon)
                }

                override fun onApiError(LIApiError: LIApiError) {
                    Log.e("error", LIApiError.toString())
                }
            })
        }
    }







}

