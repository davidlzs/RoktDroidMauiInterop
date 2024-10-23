package com.nubisuno.roktsdkimplemenation
import android.app.Activity
import android.util.Log
import com.rokt.roktsdk.Rokt

class RoktSDkWrapper {

    companion object {
        var isInitialized: Boolean = false
        var isLogging: Boolean = false

        @JvmStatic
        fun initializeSDK(clientKey: String, sdkVersion: String, view: Activity) {

            try {
                Log.d("CLIENT KEY", clientKey)
                Log.d("SDK Version", sdkVersion)
                Rokt.init(clientKey, sdkVersion, view)
            } catch (ex: Exception) {
                ex.message?.let { Log.e("CRASH", it) }
                throw ex
            }
        }

        @JvmStatic
        fun executeLayout(attributes: Map<String, String>, viewName: String) {
            try {
                Rokt.execute(viewName, attributes, object : Rokt.RoktCallback {
                    override fun onLoad() {
                    }

                    override fun onUnload(unloadReasons: Rokt.UnloadReasons) {
                    }

                    override fun onShouldHideLoadingIndicator() {
                    }

                    override fun onShouldShowLoadingIndicator() {
                    }
                })
            } catch (ex: Exception) {
                throw ex
            }
        }

        @JvmStatic
        fun executeLayoutTest(viewName: String) {
            try {

                val attributes: MutableMap<String, String> = HashMap()

                attributes["email"] = "h.lara@example.com"
                attributes["firstname"] = "Homero"
                attributes["lastname"] = "Lara"
                attributes["mobile"] = "(323) 867-5309"
                attributes["postcode"] = "90210"
                attributes["country"] = "US"
                Log.d("Execute Layout", "Starting")

                Rokt.execute(viewName, attributes, object : Rokt.RoktCallback {
                    override fun onLoad() {
                    }

                    override fun onUnload(unloadReasons: Rokt.UnloadReasons) {
                    }

                    override fun onShouldHideLoadingIndicator() {
                    }

                    override fun onShouldShowLoadingIndicator() {
                    }
                })
                Log.d("Execute Layout", "Ended")
            } catch (ex: Exception) {
                Log.d("Error Executing", ex.message.toString())
                throw ex
            }
        }

        @JvmStatic
        fun toggleLogging(loggingEnabled: Boolean) {
            try {
                Log.d("Logging", isLogging.toString())
                Rokt.setLoggingEnabled(loggingEnabled)
                Log.d("Logging", isLogging.toString())
            } catch (ex: Exception) {
                Log.d("Error", ex.message.toString())
                throw ex
            }
        }
    }
}