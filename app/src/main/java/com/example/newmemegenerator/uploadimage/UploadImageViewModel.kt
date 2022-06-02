package com.example.newmemegenerator.uploadimage

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class UploadImageViewModel: ViewModel() {

    private var isPermissionsGranted = false

    private val _snackBarFlow = MutableSharedFlow<SnackbarEvent>()
    val snackbarFlow = _snackBarFlow.asSharedFlow()

    @ExperimentalPermissionsApi
    suspend fun onUploadButtonClick(
        permissionsState: MultiplePermissionsState
    ) {
        Log.d("Mesaj:", "OnUploadClick çalıştı")
        updateOrCheckPermissions(permissionsState)
    }

    @ExperimentalPermissionsApi
    suspend fun updateOrCheckPermissions(permissionsState: MultiplePermissionsState) {
        if (permissionsState.permissions.all {
                it.hasPermission
            }) {
                Log.d("Mesaj: ", "Bütün permissionlar true")
            isPermissionsGranted = true
        }
        permissionsState.permissions.forEach {
            if (it.isPermanentlyDenied()) _snackBarFlow.emit(
                SnackbarEvent.ShowPermanentlyDeniedSnackbar(
                    "Some permissions permanently denied. You can " +
                            "enable them in the app settings."
                )
            )
        }
        permissionsState.launchMultiplePermissionRequest()
    }

}
