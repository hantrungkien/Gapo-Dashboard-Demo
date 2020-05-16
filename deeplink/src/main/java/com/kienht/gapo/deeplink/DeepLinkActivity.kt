package com.kienht.gapo.deeplink

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.deeplinkdispatch.BaseDeepLinkDelegate
import com.airbnb.deeplinkdispatch.BaseRegistry

/**
 * @author kienht
 * @company OICSoft
 * @since 10/05/2020
 */

private val deepLinkRegistryClassMap = mutableMapOf<String, Class<*>>()

class DeepLinkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val delegate = BaseDeepLinkDelegate(
            listOfNotNull(
                loadDeepLinkRegistry("com.kienht.gapo.splash.deeplink.SplashModuleRegistry"),
                loadDeepLinkRegistry("com.kienht.gapo.login.deeplink.LoginModuleRegistry"),
                loadDeepLinkRegistry("com.kienht.gapo.dashboard.deeplink.DashboardModuleRegistry"),
                loadDeepLinkRegistry("com.kienht.gapo.post_details.deeplink.PostDetailsModuleRegistry")
            )
        )
        delegate.dispatchFrom(this)

        finish()
    }

    private fun loadDeepLinkRegistry(name: String): BaseRegistry? {
        return try {
            val clazz = deepLinkRegistryClassMap[name] ?: Class.forName(name).also {
                deepLinkRegistryClassMap[name] = it
            }
            clazz.newInstance() as? BaseRegistry
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}