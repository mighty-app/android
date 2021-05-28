package cc.mightyapp.mighty.launcher.data.repository

import androidx.datastore.preferences.core.Preferences
import cc.mightyapp.mighty.common.data.entities.Result
import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {
    suspend fun saveBool(key: Preferences.Key<Boolean>, value: Boolean)
    suspend fun saveStr(key: Preferences.Key<String>, value: String)

    fun readBool(key: Preferences.Key<Boolean>): Flow<Result<Boolean>>
    fun readStr(key: Preferences.Key<String>): Flow<Result<String>>
}