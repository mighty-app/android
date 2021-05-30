package cc.mightyapp.mighty.common.di

import cc.mightyapp.mighty.common.data.api.services.UserService
import cc.mightyapp.mighty.main.main.data.repository.MainRepository
import cc.mightyapp.mighty.main.main.data.repository.RealMainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object MainModule {

    @Provides
    fun provideMainRepository(userService: UserService): MainRepository =
        RealMainRepository(userService)
}