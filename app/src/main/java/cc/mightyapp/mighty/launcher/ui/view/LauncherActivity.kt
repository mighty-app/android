package cc.mightyapp.mighty.launcher.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cc.mightyapp.mighty.common.theme.MightyTheme
import cc.mightyapp.mighty.launcher.data.entities.LaunchDestination
import cc.mightyapp.mighty.launcher.ui.composables.LauncherView
import cc.mightyapp.mighty.main.main.ui.view.launchMainActivity
import cc.mightyapp.mighty.onboarding.ui.launchOnboardingActivity
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