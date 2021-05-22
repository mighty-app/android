package cc.mightyapp.mighty.data.models


data class User(
    val id: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val isLoggedIn: Boolean = false,
    val workouts: List<Any> = listOf(),
    val xp: Int = 0,
    val poundsLiftedTotal: Int = 0,
    val level: Int = 0,
    val achievements: List<Any> = listOf(),
    val usersFollowing: List<Any> = listOf(),
    val usersFollowedBy: List<Any> = listOf(),
    val routinesFavorited: List<Any> = listOf(),
    val routinesAuthored: List<Any> = listOf(),
    val programsFollowing: List<Any> = listOf(),
    val programsAuthored: List<Any> = listOf()
)
