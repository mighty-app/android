package cc.mightyapp.mighty.common.data.fakes

import cc.mightyapp.mighty.common.data.models.User

object FakeUsers {
    val Tag = User(
        id = "123",
        firstName = "Tag",
        lastName = "Ramotar",
        email = "tag@mightyapp.cc",
        isLoggedIn = true,
        isVerified = true,
        xp = 25,
        poundsLiftedTotal = 1000,
        level = FakeLevels.LevelOne.id
    )
}