package pl.mrmatiasz.reservfastapp.presentation.navigation

sealed class Screen(val route: String) {
    data object MainScreen: Screen("main_screen")
    data object DetailsScreen: Screen("details_screen")

    data object LoginScreen: Screen("login_screen")
    data object RegistrationScreen: Screen("registration_screen")
}