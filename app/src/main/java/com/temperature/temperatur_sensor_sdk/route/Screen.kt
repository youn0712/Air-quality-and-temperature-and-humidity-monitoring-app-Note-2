package com.temperature.temperatur_sensor_sdk.route

import androidx.compose.runtime.Composable
import com.temperature.temperatur_sensor_sdk.screen.BluetoothScreen
import com.temperature.temperatur_sensor_sdk.screen.HomeScreen
import com.temperature.temperatur_sensor_sdk.screen.LineTempAndHumHistoryChartScreen
import com.temperature.temperatur_sensor_sdk.screen.LinePmHistoryChartScreen
// 定義一個封閉類別，用來表示應用中的不同畫面（Route）
sealed class Screen {
    abstract val route: String
    abstract val content: @Composable () -> Unit
 // 首頁畫面
    data object Home : Screen() {
        override val route = "Home"
        override val content: @Composable () -> Unit = { HomeScreen() }
    }
// PM2.5 歷史圖表畫面
    data object LinePmHistory : Screen() {
        override val route = "Pm History"
        override val content: @Composable () -> Unit = { LinePmHistoryChartScreen() }
    }
// 溫濕度歷史圖表畫面
    data object LineTempAndHumHistory : Screen() {
        override val route = "Temp and Hum History"
        override val content: @Composable () -> Unit = { LineTempAndHumHistoryChartScreen() }
    }
// 藍牙連線畫面
    data object Bluetooth : Screen() {
        override val route = "Bluetooth"
        override val content: @Composable () -> Unit = { BluetoothScreen() }
    }

    companion object {
        val screens by lazy { // 使用 lazy 初始化所有畫面列表，方便集中管理與導覽
            listOf(Home, LinePmHistory, LineTempAndHumHistory, Bluetooth)
        }
    }
}
