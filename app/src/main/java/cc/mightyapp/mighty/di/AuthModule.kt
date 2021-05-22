package cc.mightyapp.mighty.di

import cc.mightyapp.mighty.data.api.MightyApi
import cc.mightyapp.mighty.data.api.auth.AuthService
import cc.mightyapp.mighty.data.api.auth.RealAuthService
import cc.mightyapp.mighty.data.repository.auth.AuthRepository
import cc.mightyapp.mighty.data.repository.auth.RealAuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object AuthModule {

    @Provides
    fun provideAuthService(api: MightyApi): AuthService =
        RealAuthService(api)

    @Provides
    fun provideAuthRepository(authService: RealAuthService): AuthRepository =
        RealAuthRepository(authService)
}