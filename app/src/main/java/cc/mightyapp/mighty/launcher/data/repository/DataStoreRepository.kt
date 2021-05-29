package cc.mightyapp.mighty.launcher.data.repository

import androidx.datastore.preferences.core.Preferences
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.launcher.data.entities.DataStoreError
import kotlinx.coroutines.flow.Flow
import java.lang.Exception

interface DataStoreRepository {
    suspend fun saveStr(key: Preferences.Key<String>, value: String): RequestResult<Unit, Exception>

    fun readStr(key: Preferences.Key<String>): Flow<RequestResult<String, Exception>>
}