package com.vince.myapplication.service.model

import com.google.gson.annotations.SerializedName

data class ManifestPhotoRemoteModel(
    @field:SerializedName("earth_date") val earthDate: String,
    @field:SerializedName("total_photos") val totalPhotos: Int,

    val camera : List<String>,
    val sol : Int,
)