package cc.mightyapp.mighty.main.main.data.repository

import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.common.data.models.User
import cc.mightyapp.mighty.main.main.data.entities.GetUserInput

interface MainRepository {
    suspend fun getUser(input: GetUserInput): User
}