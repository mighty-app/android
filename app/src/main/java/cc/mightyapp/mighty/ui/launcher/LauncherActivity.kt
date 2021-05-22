package cc.mightyapp.mighty.ui.launcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cc.mightyapp.mighty.ui.onboarding.launchOnboardingActivity
import cc.mightyapp.mighty.ui.main.launchMainActivity
import cc.mightyapp.mighty.ui.theme.MightyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LauncherActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MightyTheme {
                LauncherView(
                    onComplete = { launchInfo ->
                        when (launchInfo.launchDestination) {
                            LaunchDestination.ONBOARDING -> launchOnboardingActivity(context = this)
                            LaunchDestination.MAIN -> launchMainActivity(
                                context = this,
                                userId = launchInfo.userId,
                                token = launchInfo.token
                            )
                        }
                    }
                )
            }
        }
    }
}