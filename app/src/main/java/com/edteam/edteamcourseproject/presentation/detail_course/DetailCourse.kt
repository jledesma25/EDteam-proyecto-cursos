package com.edteam.edteamcourseproject.presentation.detail_course

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.edteam.edteamcourseproject.data.Course
import com.edteam.edteamcourseproject.presentation.components.SpacerComponent
import com.edteam.edteamcourseproject.presentation.components.TopAppBarComponent
import com.edteam.edteamcourseproject.ui.theme.Background

@Composable
fun DetailScreen(
    course:Course,
    navController: NavController
) {

    println(course.name)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBarComponent(
                title = "Detalle",
                style = MaterialTheme.typography.bodyMedium,
                icon = Icons.Filled.ArrowBack,
                onItemClick = {
                    navController.popBackStack()
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://edteam-media.s3.amazonaws.com/courses/original/4f55c006-21c4-4b91-b1ce-8ba4d5721874.png")
                    .crossfade(1000)
                    .build(),
                contentDescription = "Template",
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1.5f),
                contentScale = ContentScale.Crop
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f)
                    .padding(8.dp),
                border = BorderStroke(1.dp, Color.Black),
                colors = CardDefaults.cardColors(
                    containerColor = Background
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Jetpack Compose",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "of the printing and typesetting industry. Lorem Ipsum has been the industry's",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                }
            }
        }

    }

}

/*@Preview(showSystemUi = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen()
}*/