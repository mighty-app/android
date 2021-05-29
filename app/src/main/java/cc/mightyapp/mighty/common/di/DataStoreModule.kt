package cc.mightyapp.mighty.common.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import cc.mightyapp.mighty.launcher.data.repository.DataStoreRepository
import cc.mightyapp.mighty.launcher.data.repository.RealDataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataStoreModule {
    private const val dataStoreName = "MightyDataStore"

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context) =
        PreferenceDataStoreFactory.create(
            produceFile = {
                context.preferencesDataStoreFile(dataStoreName)
            }
        )

    @Provides
    @Singleton
    fun provideDataStoreRepository(dataStore: DataStore<Preferences>): DataStoreRepository =
        RealDataStoreRepository(dataStore)
}