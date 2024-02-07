package com.example.todo.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todo.presentation.todo.ToDoDetail

@Composable
fun MainNavigationGraph(
    navController : NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home"){
            MainScreen(
                navController = navController
            )
        }

        composable("todo/detail"){
            ToDoDetail()
        }
    }
}