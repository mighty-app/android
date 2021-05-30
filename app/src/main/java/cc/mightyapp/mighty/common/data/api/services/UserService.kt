package cc.mightyapp.mighty.common.data.api.services

import cc.mightyapp.mighty.common.data.models.User
import cc.mightyapp.mighty.main.main.data.entities.GetUserInput

interface UserService {
    suspend fun getUser(input: GetUserInput): User
}