package cc.mightyapp.mighty.ui.launcher

data class LauncherViewState(
    val userId: String = "",
    val token: String = "",
    val launchDestination: LaunchDestination = LaunchDestination.ONBOARDING
)