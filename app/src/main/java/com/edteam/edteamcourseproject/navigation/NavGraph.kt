package com.edteam.edteamcourseproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.edteam.edteamcourseproject.data.Course
import com.edteam.edteamcourseproject.presentation.courses.CoursesScreen
import com.edteam.edteamcourseproject.presentation.detail_course.DetailScreen
import com.google.gson.Gson

@Composable
fun NavigationSetup() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "courses_screen"
    ){

        composable(route = "courses_screen"){
            CoursesScreen(navController)
        }
        composable(route = "detail_screen/{courseJson}"){
            val courseJson = it.arguments?.getString("courseJson")
            val course = Gson().fromJson(courseJson,Course::class.java)
            DetailScreen(course,navController)
        }

    }


}