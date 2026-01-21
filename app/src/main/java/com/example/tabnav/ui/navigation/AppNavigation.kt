package com.example.tabnav.ui.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.tabnav.ui.screens.home.HomeTab
import com.example.tabnav.ui.screens.profile.ProfileTab


class AppNavigation : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TabNavigator(HomeTab) {
                Scaffold(
                    content = { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            CurrentTab()
                        }
                    }, bottomBar = {
                        Surface(
                            shape = RoundedCornerShape(24.dp),
                            tonalElevation = 8.dp,
                            shadowElevation = 8.dp
                        ) {
                            NavigationBar(containerColor = MaterialTheme.colorScheme.surfaceContainer) {
                                TabNavigationItem(HomeTab)
                                TabNavigationItem(ProfileTab)
                            }
                        }
                    }
                )
            }
        }
    }

}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    val isSelected = tabNavigator.current == tab

    NavigationBarItem(
//        selected = tabNavigator.current == tab,
//        onClick = { tabNavigator.current = tab },
        icon = { Icon(painter = tab.options.icon!!, contentDescription = tab.options.title, tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface) },
        label={Text(tab.options.title, color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface)},
        selected = isSelected,
        onClick = { tabNavigator.current = tab },
//        icon = {
//            Box(
//                modifier = Modifier
//                    .padding(16.dp, 8.dp)
//                    .background(if (isSelected) MaterialTheme.colorScheme.surfaceVariant else Color.Transparent),
//
//            ) {
//                Icon(painter = tab.options.icon!!, contentDescription = tab.options.title, tint = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface)
//            }
//        },
        colors = NavigationBarItemDefaults.colors(indicatorColor = MaterialTheme.colorScheme.surfaceVariant)
    )

}
