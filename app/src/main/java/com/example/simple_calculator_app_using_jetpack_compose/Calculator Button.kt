package com.example.simple_calculator_app_using_jetpack_compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    symbol:String,
    modifier: Modifier = Modifier,
    OnClick : () -> Unit
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.
            clip(CircleShape)
            .clickable { OnClick() }
            .then(modifier)
    ){
        Text(
            text = symbol,
            fontSize = 36.sp,
            color = Color.White,
        )

    }


}