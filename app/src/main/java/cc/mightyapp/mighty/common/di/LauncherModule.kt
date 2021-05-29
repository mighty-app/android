package cc.mightyapp.mighty.common.di

import cc.mightyapp.mighty.common.data.api.services.AuthService
import cc.mightyapp.mighty.launcher.data.interactor.LauncherInteractor
import cc.mightyapp.mighty.launcher.data.interactor.RealLauncherInteractor
import cc.mightyapp.mighty.launcher.data.repository.LauncherRepository
import cc.mightyapp.mighty.launcher.data.repository.RealDataStoreRepository
import cc.mightyapp.mighty.launcher.data.repository.RealLauncherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher


@InstallIn(SingletonComponent::class)
@Module
object LauncherModule {

    @Provides
    fun provideLauncherRepository(authService: AuthService): LauncherRepository =
        RealLauncherRepository(authService)

    @Provides
    fun provideLauncherInteractor(
        launcherRepository: RealLauncherRepository,
        dataStoreRepository: RealDataStoreRepository,
        ioDispatcher: CoroutineDispatcher
    ): LauncherInteractor =
        RealLauncherInteractor(launcherRepository, dataStoreRepository, ioDispatcher)
}