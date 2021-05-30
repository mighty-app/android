package cc.mightyapp.mighty.main.main.ui.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import cc.mightyapp.mighty.common.theme.MightyTheme
import cc.mightyapp.mighty.main.main.ui.composables.MainContent
import dagger.hilt.android.AndroidEntryPoint

const val USER_ID = "cc.mightyapp.mighty.ui.main.USER_ID"
const val TOKEN = "cc.mightyapp.mighty.ui.main.TOKEN"

fun launchMainActivity(context: Context, userId: String, token: String) {
    val intent = Intent(context, MainActivity::class.java).apply {
        putExtra(USER_ID, userId)
        putExtra(TOKEN, token)
    }
    context.startActivity(intent)
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userId = intent.getStringExtra(USER_ID)
        val token = intent.getStringExtra(TOKEN)

        setContent {

            MightyTheme {
                MainContent(userId = userId!!, token = token!!)
            }

        }

    }
}