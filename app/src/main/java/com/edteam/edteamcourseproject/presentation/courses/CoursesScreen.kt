package com.edteam.edteamcourseproject.presentation.courses

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.edteam.edteamcourseproject.R
import com.edteam.edteamcourseproject.data.Course
import com.edteam.edteamcourseproject.presentation.components.CourseHeader
import com.edteam.edteamcourseproject.presentation.components.CourseItem
import com.edteam.edteamcourseproject.presentation.components.TopAppBarComponent
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

@Composable
fun CoursesScreen(navController: NavController) {

    val context = LocalContext.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        topBar = {
            TopAppBarComponent(
                title = stringResource(R.string.courses_title),
                style = MaterialTheme.typography.bodyMedium,
                icon = Icons.Filled.Menu,
                onItemClick = {

                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
            contentPadding = PaddingValues(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            item {
                CourseHeader(
                    title = stringResource(R.string.courses_subtitle),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.Monospace
                    )
                )
            }

            val gson = Gson()
            val json = loadData(context, "data_courses.json")
            val itemType = object : TypeToken<List<Course>>() {}.type
            val courses = gson.fromJson<List<Course>>(json, itemType)

            items(courses) { course ->
                CourseItem(
                    course = course,
                    onItemClick = {
                        val courseJson = Gson().toJson(course)
                        navController.navigate("detail_screen/$courseJson")
                    }
                )
            }

        }

    }

}

fun loadData(context: Context, file: String): String {
    var contents = ""

    try {
        val stream = context.assets.open(file)
        val size = stream.available()
        val buffer = ByteArray(size)
        stream.read(buffer)
        stream.close()
        contents = String(buffer)
    } catch (ex: IOException) {
        throw ex
    }
    return contents
}


/*@Preview(showSystemUi = true)
@Composable
fun CoursesScreenPreview() {
    CoursesScreen()
}*/