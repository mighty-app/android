package cc.mightyapp.mighty.common.data.api.services

import cc.mightyapp.mighty.common.data.api.MightyApi
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.common.data.models.Level
import cc.mightyapp.mighty.common.data.models.User
import cc.mightyapp.mighty.main.main.data.entities.GetUserInput
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RealUserService @Inject constructor(
    private val api: MightyApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : UserService {

    override suspend fun getUser(input: GetUserInput): User =
        withContext(ioDispatcher) { api.getUser(id = input.userId) }

    override suspend fun getUserLevel(levelId: String): Level =
        withContext(ioDispatcher) { api.getLevel(levelId = levelId)}
}