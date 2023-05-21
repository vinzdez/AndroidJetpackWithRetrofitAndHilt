package com.vince.myapplication.data

import com.vince.myapplication.domain.model.RoverManifestUiState
import com.vince.myapplication.domain.model.RoverPhotoUiModel
import com.vince.myapplication.domain.model.RoverPhotoUiState
import com.vince.myapplication.domain.model.toUiModel
import com.vince.myapplication.service.MarsRoverManifestService
import com.vince.myapplication.service.MarsRoverPhotoService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarsRoverPhotoRepo @Inject constructor(
    private val marsRoverPhotoService: MarsRoverPhotoService
){
    fun getMarsRoverPhoto(roverName: String , sol: String): Flow<RoverPhotoUiState> = flow{
        try {
            val networkResult = marsRoverPhotoService.getMarsPhotos(roverName , sol)
            emit(RoverPhotoUiState.Success(networkResult.photos.map {
                photo ->
                RoverPhotoUiModel(
                    id = photo.id,
                    roverName = photo.rover.name,
                    imgSrc = photo.imgSrc,
                    sol = photo.sol.toString(),
                    earthData = photo.earDate,
                    cameraFullName = photo.camera.fullName
                )

            })

            )
        }catch (error: Throwable){
             emit(RoverPhotoUiState.Error)
        }
    }
}