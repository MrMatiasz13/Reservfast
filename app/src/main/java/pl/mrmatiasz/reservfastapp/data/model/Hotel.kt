package pl.mrmatiasz.reservfastapp.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Hotel(
    val id: Int = 0,
    val name: String = "",
    val city: String = "",
    val address: String = "",
    val phone: Int = 0,
    val stars: Int = 0
)
