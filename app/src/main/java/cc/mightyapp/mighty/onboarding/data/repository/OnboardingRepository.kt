package cc.mightyapp.mighty.onboarding.data.repository

import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailInput
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailResponse

interface OnboardingRepository {
    suspend fun logInWithEmail(input: LogInWithEmailInput): LogInWithEmailResponse
}