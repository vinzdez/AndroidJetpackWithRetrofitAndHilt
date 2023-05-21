package com.vince.myapplication.ui.theme.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.vince.myapplication.ui.theme.photolist.MarsRoverPhotoViewModel

@Composable
fun PhotoScreen(
    roverName: String?,
    sol: String?,
    marsRoverPhotoViewModel: MarsRoverPhotoViewModel
) {
    if(roverName != null && sol != null){
        LaunchedEffect(Unit){
            marsRoverPhotoViewModel.getMarsRoverPhoto(roverName = roverName , sol = sol)
        }
    }
    Text(text = "PhotoScreen")
}