package com.cornellappdev.apollo_android_tutorial

data class Mission(val name: String, val patchSize : String)
data class Rocket(val id : String, val name: String, val type: String)
data class Launch(val id: String, val site : String, val mission: Mission, val rocket: Rocket, val isBooked : Boolean)
