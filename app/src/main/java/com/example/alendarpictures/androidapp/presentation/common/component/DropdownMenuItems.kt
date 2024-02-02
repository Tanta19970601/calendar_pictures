package com.example.alendarpictures.androidapp.presentation.common.component

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.w3c.dom.Text

@Composable
fun DropdownMenuItems(
    name: String = "",
    onClick: () -> Unit
) {
    DropdownMenuItem(
        text = { Text(name) },
        onClick = onClick
    )
}