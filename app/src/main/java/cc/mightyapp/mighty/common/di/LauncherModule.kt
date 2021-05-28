package cc.mightyapp.mighty.common.di

import cc.mightyapp.mighty.common.data.api.services.AuthService
import cc.mightyapp.mighty.launcher.data.repository.LauncherRepository
import cc.mightyapp.mighty.launcher.data.repository.RealLauncherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object LauncherModule {

    @Provides
    fun provideLauncherRepository(authService: AuthService): LauncherRepository =
        RealLauncherRepository(authService)
}