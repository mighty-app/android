package cc.mightyapp.mighty.common.di

import cc.mightyapp.mighty.common.data.api.services.AuthService
import cc.mightyapp.mighty.onboarding.data.repository.OnboardingRepository
import cc.mightyapp.mighty.onboarding.data.repository.RealOnboardingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object OnboardingModule {

    @Provides
    fun provideOnboardingRepository(authService: AuthService): OnboardingRepository =
        RealOnboardingRepository(authService)
}