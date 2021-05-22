package cc.mightyapp.mighty.data.repository.datastore

import androidx.datastore.preferences.core.Preferences
import cc.mightyapp.mighty.domain.result.Result
import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {
    suspend fun saveBool(key: Preferences.Key<Boolean>, value: Boolean)
    suspend fun saveStr(key: Preferences.Key<String>, value: String)

    fun readBool(key: Preferences.Key<Boolean>): Flow<Result<Boolean>>
    fun readStr(key: Preferences.Key<String>): Flow<Result<String>>
}