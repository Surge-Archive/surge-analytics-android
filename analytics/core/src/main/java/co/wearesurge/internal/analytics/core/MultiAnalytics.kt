package co.wearesurge.internal.analytics.core

class MultiAnalytics(private vararg val analytics: SurgeAnalytics) : SurgeAnalytics {
    override fun logEvent(event: Event) =
        analytics.forEach { it.logEvent(event) }

    override fun setProperty(key: String, value: String) =
        analytics.forEach { it.setProperty(key, value) }

    override fun setEnabled(isEnabled: Boolean) =
        analytics.forEach { it.setEnabled(isEnabled) }
}