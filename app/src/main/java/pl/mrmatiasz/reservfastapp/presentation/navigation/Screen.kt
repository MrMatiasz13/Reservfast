package pl.mrmatiasz.reservfastapp.presentation.navigation

sealed class Screen(val route: String) {
    data object MainScreen: Screen("main_screen")
}