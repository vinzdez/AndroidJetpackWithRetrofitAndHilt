package com.vince.myapplication.ui.theme.photolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vince.myapplication.data.MarsRoverPhotoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarsRoverPhotoViewModel @Inject constructor(
    private val marsRoverPhotoRepo: MarsRoverPhotoRepo
) : ViewModel() {
    fun getMarsRoverPhoto(roverName : String, sol:String){
        viewModelScope.launch {
            marsRoverPhotoRepo.getMarsRoverPhoto(roverName, sol).collect {

            }
        }

    }

}  