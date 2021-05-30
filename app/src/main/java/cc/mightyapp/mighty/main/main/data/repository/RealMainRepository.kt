package cc.mightyapp.mighty.main.main.data.repository

import cc.mightyapp.mighty.common.data.api.services.UserService
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.common.data.models.Level
import cc.mightyapp.mighty.common.data.models.User
import cc.mightyapp.mighty.main.main.data.entities.GetUserInput
import javax.inject.Inject

class RealMainRepository @Inject constructor(
    private val userService: UserService
) : MainRepository {
    override suspend fun getUser(input: GetUserInput): User =
        userService.getUser(input)

    override suspend fun getUserLevel(levelId: String): Level = userService.getUserLevel(levelId)
}