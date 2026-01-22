package com.example.tabnav.ui.screens.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.tabnav.ui.components.ButtonMode
import com.example.tabnav.ui.components.ButtonModeInfo
import com.example.tabnav.ui.components.ClickButton


object HomeTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Home"
            val icon = rememberVectorPainter(Icons.Default.Home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }

        }

    @Composable
    override fun Content() {
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Text(text = "Home")
            Spacer(modifier = Modifier.height(40.dp))
            ButtonMode(ButtonModeInfo("Single Click", "Repeatedly clicks on the same area"))
            Spacer(modifier = Modifier.height(10.dp))
            ClickButton()
        }
    }
}