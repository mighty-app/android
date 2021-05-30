package cc.mightyapp.mighty.common.di

import cc.mightyapp.mighty.common.data.api.MightyApi
import cc.mightyapp.mighty.common.data.api.services.ExercisesService
import cc.mightyapp.mighty.common.data.api.services.RealExercisesService
import cc.mightyapp.mighty.main.exercises.data.repository.ExercisesRepository
import cc.mightyapp.mighty.main.exercises.data.repository.RealExercisesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object ExercisesModule {

    @Provides
    fun provideExercisesService(api: MightyApi): ExercisesService = RealExercisesService(api = api)

    @Provides
    fun provideExercisesRepository(exercisesService: ExercisesService): ExercisesRepository =
        RealExercisesRepository(exercisesService = exercisesService)
}