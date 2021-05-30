package cc.mightyapp.mighty.onboarding.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import cc.mightyapp.mighty.common.ui.theme.MightyTheme
import dagger.hilt.android.AndroidEntryPoint

fun launchOnboardingActivity(context: Context) {
    context.startActivity(Intent(context, OnboardingActivity::class.java))
}

@AndroidEntryPoint
class OnboardingActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MightyTheme {
                OnboardingContent {
                    finish()
                }
            }
        }
    }
}