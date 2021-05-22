package cc.mightyapp.mighty.ui.launcher

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import cc.mightyapp.mighty.R
import kotlinx.coroutines.delay

private const val SplashWaitTime: Long = 2000

data class LaunchInfo(
    val userId: String = "",
    val token: String = "",
    val launchDestination: LaunchDestination
)

@Composable
fun LauncherView(
    modifier: Modifier = Modifier,
    onComplete: (LaunchInfo) -> Unit
) {
    val viewModel: LauncherViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        val onTimeout by rememberUpdatedState(onComplete)

        LaunchedEffect(Unit) {
            delay(SplashWaitTime)
            onTimeout(
                LaunchInfo(
                    userId = state.userId,
                    token = state.token,
                    launchDestination = state.launchDestination
                )
            )
        }

        Image(
            painter = painterResource(id = R.mipmap.ic_mighty_foreground),
            contentDescription = null
        )
    }
}