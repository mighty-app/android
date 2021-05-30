package cc.mightyapp.mighty.common.di

import cc.mightyapp.mighty.common.data.api.MightyApi
import cc.mightyapp.mighty.common.data.api.services.RealUserService
import cc.mightyapp.mighty.common.data.api.services.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UserModule {

    @Provides
    fun provideUserService(api: MightyApi): UserService = RealUserService(api)
}