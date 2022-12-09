package com.example.coffe4coders.ui.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DeatailScreen(){
Text(text = "Es un detalle ", style = MaterialTheme.typography.h3)
}

@Preview(showBackground = true)
@Composable
fun DeatailScreenPreview(){
DeatailScreen()
}