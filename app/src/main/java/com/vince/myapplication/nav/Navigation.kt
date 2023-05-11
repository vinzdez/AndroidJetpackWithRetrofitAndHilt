package com.vince.myapplication.nav

import androidx.navigation.NavController
import com.vince.myapplication.nav.Destination.Home

object Destination {
    const val Home = "home"
    const val Manifest = "manifest/{roverName}"
}

class Action(navController: NavController){
    val home: () -> Unit = { navController.navigate(Home)}
    val manifest: (roverName : String) -> Unit = { roverName ->
        navController.navigate("manifest/${roverName}")
    }
}