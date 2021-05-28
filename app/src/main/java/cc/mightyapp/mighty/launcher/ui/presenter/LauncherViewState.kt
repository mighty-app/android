package cc.mightyapp.mighty.launcher.ui.presenter

import cc.mightyapp.mighty.launcher.data.entities.LaunchDestination

data class LauncherViewState(
    val userId: String = "",
    val token: String = "",
    val launchDestination: LaunchDestination = LaunchDestination.ONBOARDING
)