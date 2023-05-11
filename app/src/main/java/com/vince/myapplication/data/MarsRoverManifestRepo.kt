package com.vince.myapplication.data

import com.vince.myapplication.domain.model.RoverManifestUiState
import com.vince.myapplication.service.MarsRoverManifestService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarsRoverManifestRepo @Inject constructor(
    private val marsRoverManifestService: MarsRoverManifestService
){
    fun getMarsRoverManifest(roverName: String): Flow<RoverManifestUiState> = flow{

    }
}