package cc.mightyapp.mighty.data.repository.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKeys {
    val userId = stringPreferencesKey("USER_ID")
    val token = stringPreferencesKey("TOKEN")
    val onboardingIsCompleted = booleanPreferencesKey("ONBOARDING_IS_COMPLETED")
}