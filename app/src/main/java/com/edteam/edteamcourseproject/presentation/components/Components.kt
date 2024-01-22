package com.edteam.edteamcourseproject.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.edteam.edteamcourseproject.R
import com.edteam.edteamcourseproject.data.Course
import com.edteam.edteamcourseproject.ui.theme.Background

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    title: String,
    style: TextStyle,
    icon:ImageVector,
    onItemClick: () -> Unit
) {

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = style
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Background,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { onItemClick() }) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }

        },
        actions = {
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "Info",
                tint = Color.White
            )
        },
        modifier = Modifier.fillMaxWidth()
    )

}

@Composable
fun CourseHeader(
    title: String,
    style: TextStyle
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = style
        )
        Spacer(modifier = Modifier.height(4.dp))
        DividerComponent(
            unit = 2.dp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }

}

@Composable
fun DividerComponent(
    unit: Dp,
    color: Color
) {
    Divider(thickness = unit, color = color)
}

@Composable
fun SpacerComponent(
    modifier: Modifier = Modifier
) {
    Spacer(modifier = modifier)
}

@Composable
fun CourseItem(
    course: Course,
    onItemClick:(Course)->Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(course)
            },
        border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://edteam-media.s3.amazonaws.com/courses/original/${course.picture}")
                        .crossfade(1000)
                        .build(),
                    contentDescription = "Template",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Background)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = course.name,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }
    }
}

