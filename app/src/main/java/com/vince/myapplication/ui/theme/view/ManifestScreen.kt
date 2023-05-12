package com.vince.myapplication.ui.theme.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vince.myapplication.domain.model.RoverManifestUiState
import com.vince.myapplication.ui.theme.manidestlist.MarsRoverManifestViewModel

@Composable
fun ManifestScreen(
    roverName: String?,
    marsRoverManifestViewModel: MarsRoverManifestViewModel,
    onClick: (roverName: String, sol: String) -> Unit
) {

    val viewState by marsRoverManifestViewModel.roverManifestUiState.collectAsStateWithLifecycle()

    if(roverName != null){
        LaunchedEffect(Unit){
            marsRoverManifestViewModel.getMarsRoverManifest(roverName)
        }
        
        when(val roverManifestUiState = viewState){
            RoverManifestUiState.Error -> Error()
            RoverManifestUiState.Loading -> Loading()
            is RoverManifestUiState.Success -> ManifestList(roverManifestUiModel = roverManifestUiState.roverManifestUiModelList, roverName ,onClick)
        }
    }
}
