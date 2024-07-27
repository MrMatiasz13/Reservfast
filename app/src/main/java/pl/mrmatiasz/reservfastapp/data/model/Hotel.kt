package pl.mrmatiasz.reservfastapp.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Hotel(
    val id: String,
    val name: String,
    val city: String,
    val address: String,
    val phoneNUmber: Int,
    val numberOfStars: Int,
    val titleImage: ImageVector? = null
) {
    constructor() : this("", "", "", "", 0, 0, null)
}
