package co.wearesurge.internal.analytics.firebase

import co.wearesurge.internal.analytics.core.Event
import co.wearesurge.internal.analytics.core.SurgeAnalytics
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class SurgeAnalyticsFirebase : SurgeAnalytics {
    val firebaseAnalytics: FirebaseAnalytics by lazy { Firebase.analytics }

    override fun logEvent(event: Event) {
        firebaseAnalytics.logEvent(event.getFirebaseEventId(), event.params)
    }

    override fun setProperty(key: String, value: String) {
        firebaseAnalytics.setUserProperty(key, value)
    }

    override fun setEnabled(isEnabled: Boolean) {
        firebaseAnalytics.setAnalyticsCollectionEnabled(isEnabled)
    }

    private fun Event.getFirebaseEventId() = when (this) {
        is Event.AppOpen -> FirebaseAnalytics.Event.APP_OPEN
        is Event.AddToBasket -> FirebaseAnalytics.Event.ADD_TO_CART
        is Event.ScreenView -> FirebaseAnalytics.Event.SCREEN_VIEW
        is Event.SignUp -> FirebaseAnalytics.Event.SIGN_UP
        is Event.Login -> FirebaseAnalytics.Event.LOGIN
        is Event.CustomEvent -> this.id
    }
}