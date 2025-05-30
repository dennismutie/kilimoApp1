package com.agro.kilimo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.agro.kilimo.ui.theme.screens.about.AboutScreen
import com.agro.kilimo.ui.theme.screens.contact.ContactScreen
import com.agro.kilimo.ui.theme.screens.dashboard.DashboardScreen
import com.agro.kilimo.ui.theme.screens.home.HomeScreen
import com.agro.kilimo.ui.theme.screens.intent.Intent_Screen
import com.agro.kilimo.ui.theme.screens.item.ItemScreen
import com.agro.kilimo.ui.theme.screens.login.LoginScreen
import com.agro.kilimo.ui.theme.screens.productse.AddProductsScreen
import com.agro.kilimo.ui.theme.screens.productse.UpdateProductsScreen
import com.agro.kilimo.ui.theme.screens.productse.ViewProductsScreen
import com.agro.kilimo.ui.theme.screens.register.RegisterScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_LOGIN
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }

        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_ITEM) {
            ItemScreen(navController)
        }

        composable(ROUT_LOGIN) {
            LoginScreen(navController)
        }

        composable(ROUT_INTENT) {
            Intent_Screen(navController)
        }
        composable(ROUT_ADDPRODUCTSCREEN) {
            AddProductsScreen(navController)
        }
        composable(
            route = "$ROUT_UPDATEPRODUCTSCREEN/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            UpdateProductsScreen(navController, productId)
        }
        composable(ROUT_VIEWPRODUCTSCREEN) {
            ViewProductsScreen(navController)
        }

        composable(ROUT_CONTACT) {
            ContactScreen(navController)
        }
        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }
        composable(ROUT_REGISTER) {
            RegisterScreen(navController)
        }
    }
}