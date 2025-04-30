package com.temperature.temperatur_sensor_sdk

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.temperature.temperatur_sensor_sdk.screen.MainScreen
import com.temperature.temperatur_sensor_sdk.ui.theme.TemperatursensorsdkTheme
import com.temperature.temperatur_sensor_sdk.util.BluetoothUtil
// 主活動，應用程式進入點，負責初始化藍牙權限與顯示主畫面
class MainActivity : ComponentActivity() {
    private lateinit var bluetoothPermissionLauncher: ActivityResultLauncher<Array<String>>// 宣告藍牙權限請求啟動器

    companion object {
        private var permissionLauncher: ActivityResultLauncher<Array<String>>? = null // 靜態變數儲存權限啟動器實例，供其他類別呼叫

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)// 呼叫父類別的 onCreate 方法
        enableEdgeToEdge()  // 啟用全螢幕邊緣到邊緣的顯示模式
  // 初始化藍牙權限請求啟動器，並指定取得權限後的回呼邏輯
        bluetoothPermissionLauncher = BluetoothUtil.setupBluetoothPermissionLauncher(this) { granted ->
            if (granted) { // 如果使用者授權成功
                Log.i("MainActivity", "Bluetooth permission granted") // 印出取得藍牙權限的訊息
            }
        }
        permissionLauncher = bluetoothPermissionLauncher  // 將啟動器指派給靜態變數，供全域使用
 // 設定畫面內容，使用 Jetpack Compose 主題與主畫面
        setContent {
            TemperatursensorsdkTheme {
                MainScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    TemperatursensorsdkTheme {
        MainScreen()
    }
}
