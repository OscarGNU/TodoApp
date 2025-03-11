package com.juandgaines.todoapp.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.juandgaines.todoapp.presentation.home.HomeScreenRoot
import com.juandgaines.todoapp.presentation.screen.detail.TaskScreenRoot

import kotlinx.serialization.Serializable

@Composable
fun NavigationRoot (
    navController: NavHostController
){
    Box (
        modifier = Modifier.fillMaxSize()
    ){
        NavHost(
            navController = navController,
            startDestination = HomeScreenDes
        ){
            composable<HomeScreenDes>{
                HomeScreenRoot(
                    navigateToTaskScreen = {
                        navController.navigate(TaskScreenDes(it))
                    }
                )
            }

            composable<TaskScreenDes> {
                TaskScreenRoot(
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}

@Serializable
object HomeScreenDes

@Serializable
data class TaskScreenDes(
    val taskId: String? = null
)