@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package com.plcoding.material3expressiveguide.motion

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun MotionPhysicsDemo() {
    var isScaledDown by remember {
        mutableStateOf(true)
    }
    val animationProgress by animateFloatAsState(
        targetValue = if(isScaledDown) 0f else 1f,
        animationSpec = MaterialTheme.motionScheme.fastSpatialSpec()
    )
    Box(
        modifier = Modifier
            .size(100.dp)
            .graphicsLayer {
                this.scaleX = 1f + animationProgress
                this.scaleY = 1f + animationProgress
            }
            .background(Color.Red)
            .clickable {
                isScaledDown = !isScaledDown
            }
    )
}