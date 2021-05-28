package cc.mightyapp.mighty.onboarding.data.repository

import cc.mightyapp.mighty.common.data.api.services.AuthService
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailInput
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailResponse
import javax.inject.Inject

class RealOnboardingRepository @Inject constructor(
    private val authService: AuthService
) : OnboardingRepository {
    override suspend fun logInWithEmail(input: LogInWithEmailInput): LogInWithEmailResponse =
        authService.logInWithEmail(input)
}