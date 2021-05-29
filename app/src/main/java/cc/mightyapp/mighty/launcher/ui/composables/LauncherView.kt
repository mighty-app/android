package cc.mightyapp.mighty.launcher.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import cc.mightyapp.mighty.R
import cc.mightyapp.mighty.launcher.data.entities.LaunchDestination
import cc.mightyapp.mighty.launcher.ui.presenter.LauncherViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

private const val SplashWaitTime: Long = 1250

data class LaunchInfo(
    val userId: String,
    val token: String,
    val launchDestination: LaunchDestination
)

@Composable
fun LauncherView(
    modifier: Modifier = Modifier,
    onComplete: (LaunchInfo) -> Unit
) {
    val viewModel: LauncherViewModel = viewModel()

    val isDoneLoading by viewModel.isDoneLoading.collectAsState()
    val hasError by viewModel.hasError.collectAsState()

    val state by viewModel.state.collectAsState()
    val launchDestination by viewModel.destination.collectAsState()

    ShowSplash(modifier = modifier)

    if (isDoneLoading) {
        LaunchedEffect(launchDestination) {
            onComplete(
                LaunchInfo(
                    userId = state.userId,
                    token = state.token,
                    launchDestination = launchDestination
                )
            )
        }
    }
}

@Composable
fun ShowSplash(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_mighty),
            contentDescription = null
        )
    }
}

@Composable
fun Navigate(onComplete: (LaunchInfo) -> Unit, launchInfo: LaunchInfo) {
    LaunchedEffect(Unit) {
        onComplete(launchInfo)
    }
}