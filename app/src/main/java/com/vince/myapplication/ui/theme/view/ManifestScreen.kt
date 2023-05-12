package com.vince.myapplication.ui.theme.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import com.vince.myapplication.ui.theme.manidestlist.MarsRoverManifestViewModel

@Composable
fun ManifestScreen(
    roverName: String?,
    marsRoverManifestViewModel: MarsRoverManifestViewModel
) {
    if(roverName != null){
        LaunchedEffect(Unit){
            marsRoverManifestViewModel.getMarsRoverManifest(roverName)
        }
    }
    Text(text = "Manifest Screen $roverName")
}

@Preview
@Composable
fun ManifestScreenPreview() {
   // ManifestScreen("Perseverance")
}