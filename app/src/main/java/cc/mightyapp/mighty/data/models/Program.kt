package cc.mightyapp.mighty.data.models

data class Program(
    val name: String,
    val routines: List<Routine>,
    val isFeatured: Boolean
)
