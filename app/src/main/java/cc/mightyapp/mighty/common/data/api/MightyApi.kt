package cc.mightyapp.mighty.common.data.api

import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.common.data.models.Exercise
import cc.mightyapp.mighty.common.data.models.Level
import cc.mightyapp.mighty.common.data.models.User
import cc.mightyapp.mighty.common.util.Constants.Companion.SAFE_TOKEN
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenInput
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenResponse
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailInput
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailResponse
import retrofit2.http.*

interface MightyApi {

    // Auth

    @POST("/auth/login/email")
    suspend fun logInWithEmail(
        @Body input: LogInWithEmailInput
    ): RequestResult<LogInWithEmailResponse, Exception>

    @POST("/auth/validate/token")
    suspend fun validateToken(
        @Body input: ValidateTokenInput
    ): RequestResult<ValidateTokenResponse, Exception>

    // Exercise

    @Headers("Authorization: Bearer $SAFE_TOKEN")
    @GET("/v1/exercises")
    suspend fun getExercises(): List<Exercise>

    @Headers("Authorization: Bearer $SAFE_TOKEN")
    @GET("/v1/exercises/{exerciseId}")
    suspend fun getExercise(
        @Path("exerciseId") exerciseId: String
    ): Exercise

    @Headers("Authorization: Bearer $SAFE_TOKEN")
    @GET("/v1/exercises/muscles/{muscleId}")
    suspend fun getExercisesByMuscle(
        @Path("muscleId") muscleId: String
    ): List<Exercise>

    // Level

    @Headers("Authorization: Bearer $SAFE_TOKEN")
    @GET("/v1/levels/{levelId}")
    suspend fun getLevel(
        @Path("levelId") levelId: String
    ): Level

    // User

    @Headers("Authorization: Bearer $SAFE_TOKEN")
    @GET("/v1/users/{id}")
    suspend fun getUser(
        @Path("id") id: String
    ): User
}

