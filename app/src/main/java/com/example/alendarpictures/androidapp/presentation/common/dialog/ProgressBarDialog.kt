package com.example.alendarpictures.androidapp.presentation.common.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun ProgressBarDialog(
    properties: DialogProperties = DialogProperties(),
    onDismissRequest: () -> Unit = {},
    isShow: Boolean,
) {
    if (isShow) {
        Dialog(
            onDismissRequest = onDismissRequest,
            properties = properties
        ) {
            Card(
                modifier = Modifier.size(size = 35.dp),
            ) {
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(size = 35.dp),
                        strokeWidth = 4.dp
                    )
                }
            }
        }
    }
}