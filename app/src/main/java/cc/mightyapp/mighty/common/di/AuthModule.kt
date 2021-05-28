package cc.mightyapp.mighty.common.di

import cc.mightyapp.mighty.common.data.api.MightyApi
import cc.mightyapp.mighty.common.data.api.services.AuthService
import cc.mightyapp.mighty.common.data.api.services.RealAuthService
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
}