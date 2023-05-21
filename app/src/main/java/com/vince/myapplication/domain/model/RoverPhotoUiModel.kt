package com.vince.myapplication.domain.model

sealed class RoverPhotoUiState{
    data class Success(
        val roverPhotoUiModelList: List<RoverPhotoUiModel>
    ) : RoverPhotoUiState()
    object Leading: RoverPhotoUiState()
    object  Error: RoverPhotoUiState()
}

data class RoverPhotoUiModel (
    val id : Int,
    val roverName : String,
    val imgSrc: String,
    val sol: String,
    val earthData: String,
    val cameraFullName: String
)