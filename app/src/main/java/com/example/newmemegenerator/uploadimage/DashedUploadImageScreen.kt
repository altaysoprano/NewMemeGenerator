package com.example.newmemegenerator.uploadimage

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.newmemegenerator.R

@Composable
fun DashedUploadImageScreen(
    onUploadButtonClick: () -> Unit
) {
    val stroke = Stroke(
        width = 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Box(modifier = Modifier
            .align(Alignment.Center)
            .clickable { onUploadButtonClick() }) {
            Canvas(modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(0.8f)) {
                drawRoundRect(color = Color.LightGray, style = stroke)
            }
            Box(modifier = Modifier.align(Center)) {
                Column {
                    Icon(
                        painter = painterResource(R.drawable.upload_icon),
                        contentDescription = "Upload Icon",
                        modifier = Modifier
                            .size(48.dp, 48.dp)
                            .align(CenterHorizontally),
                        tint = MaterialTheme.colors.primary
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Select image from gallery",
                        color = MaterialTheme.colors.primary
                    )
                }
            }
        }
    }
}























