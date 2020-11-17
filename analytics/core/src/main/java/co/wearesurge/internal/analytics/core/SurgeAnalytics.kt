package co.wearesurge.internal.analytics.core

interface SurgeAnalytics {
    fun logEvent(event: Event)
    fun setProperty(key: String, value: String)
    fun setEnabled(isEnabled: Boolean)
}

