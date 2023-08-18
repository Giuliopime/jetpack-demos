package dev.giuliopime.jetpackdemos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import dev.giuliopime.jetpackdemos.demos.bottomAppBar.BottomAppBarScreen
import dev.giuliopime.jetpackdemos.demos.bottomsheet.ModalBottomSheetScreen
import dev.giuliopime.jetpackdemos.demos.colorpicker.ColorPickerScreen
import dev.giuliopime.jetpackdemos.ui.theme.JetpackDemosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // We handle all the insets manually
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            JetpackDemosTheme {
                //ModalBottomSheetScreen()
                //ColorPickerScreen()
                 BottomAppBarScreen()
            }
        }
    }
}