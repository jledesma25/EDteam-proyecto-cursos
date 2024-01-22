package com.edteam.edteamcourseproject.data

import java.io.Serializable

data class Course(
    val name:String,
    val subtitle:String,
    val picture:String,
    val slug:String,
    val duration:String,
    val start:String,
    val level:String,
    val detail:String,
) : Serializable
