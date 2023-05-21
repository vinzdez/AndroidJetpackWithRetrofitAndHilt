package com.vince.myapplication

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vince.myapplication.nav.Action
import com.vince.myapplication.nav.Destination.Home
import com.vince.myapplication.nav.Destination.Manifest
import com.vince.myapplication.nav.Destination.Photo
import com.vince.myapplication.ui.theme.MarsRoverTheme
import com.vince.myapplication.ui.theme.view.ManifestScreen
import com.vince.myapplication.ui.theme.view.PhotoScreen
import com.vince.myapplication.ui.theme.view.RoverList

@Composable
fun NavCompose() {
    val navController = rememberNavController()
    val actions = remember(navController) { Action(navController) }
    MarsRoverTheme {
        NavHost(navController ,Home ){
            composable(Home) {
                RoverList(){ roverName ->
                    actions.manifest(roverName)
                }
            }
            composable(Manifest){ backStackEntry ->
                ManifestScreen(
                    backStackEntry.arguments?.getString("roverName"),
                    marsRoverManifestViewModel = hiltViewModel(),
                    onClick = { roverName, sol ->
                        actions.photo(roverName, sol)
                    }
                )
            }
            composable(Photo){ backStackEntry ->
                PhotoScreen(
                    roverName = backStackEntry.arguments?.getString("roverName"),
                    sol = backStackEntry.arguments?.getString("sol"),
                    marsRoverPhotoViewModel = hiltViewModel()
                )
            }
        }
    }
}