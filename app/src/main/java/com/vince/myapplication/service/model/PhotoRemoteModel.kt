package com.vince.myapplication.service.model

import com.google.gson.annotations.SerializedName

data class PhotoRemoteModel(
    val camera: CameraRemoteModel,
    @field:SerializedName("earth_date") val earDate: String,
    val id: Int,
    @field:SerializedName("img_src") val imgSrc: String,
    val rover: RoverRemoteModel,
    val sol: Int
)