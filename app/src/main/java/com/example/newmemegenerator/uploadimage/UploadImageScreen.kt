package com.example.newmemegenerator.uploadimage

import android.Manifest
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@ExperimentalPermissionsApi
@Composable
fun UploadImageScreen(
    viewModel: UploadImageViewModel = hiltViewModel(),
) {

    val permissionsState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    )
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.snackbarFlow.collectLatest { event ->
            when (event) {
                is SnackbarEvent.ShowPermanentlyDeniedSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = Color.Transparent
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            DashedUploadImageScreen {
                viewModel.viewModelScope.launch {
                    viewModel.onUploadButtonClick(permissionsState = permissionsState)
                }
            }
        }
    }
}
