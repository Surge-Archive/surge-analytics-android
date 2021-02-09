package co.wearesurge.internal.analytics.core

import android.os.Bundle

sealed class Event {
    abstract val id: String
    abstract val params: Bundle?

    data class AppOpen(
        override val params: Bundle? = null
    ) : Event() {
        override val id: String = "app_open"
    }

    data class AddToBasket(
        override val params: Bundle? = null
    ) : Event() {
        override val id: String = "add_to_basket"
    }

    data class ScreenView(
        override val params: Bundle? = null
    ) : Event() {
        override val id: String = "screen_view"
    }

    data class SignUp(
        override val params: Bundle? = null
    ) : Event() {
        override val id: String = "sign_up"
    }

    data class Login(
        override val params: Bundle? = null
    ) : Event() {
        override val id: String = "login"
    }

    // TODO Add other common events

    data class CustomEvent(
        override val id: String,
        override val params: Bundle? = null
    ) : Event()
}