package com.vince.myapplication.service.model

import com.google.gson.annotations.SerializedName


data class PhotoManifestRemoteModel(
    @field:SerializedName("landing_date") val landingDate: String,
    @field:SerializedName("launch_date") val launchDate: String,
    @field:SerializedName("max_date") val maxDate: String,
    @field:SerializedName("max_sol") val maxSol: String,
    @field:SerializedName("total_photo") val totalPhotos: Int,

    val name: String,
    val photos: List<ManifestPhotoRemoteModel>,
    val status : String,


)
