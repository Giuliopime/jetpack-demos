package dev.giuliopime.jetpackdemos.demos.colorpicker

import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt

fun String.toColorOrNull(): Color? = try {
    Color(toColorInt())
} catch (_: IllegalArgumentException) {
    null
}

fun String.toColor(fallback: Color) = toColorOrNull() ?: fallback

fun Color.contrastColor(): Color {
    // Calculate the perceptive luminance (aka luma) - human eye favors green color...
    val luma = (0.299 * red) + (0.587 * green) + (0.114 * blue)

    // Return black for bright colors, white for dark colors
    return if (luma > 0.6) {
        Color.Black
    } else {
        Color.White
    }
}

object Patterns {
    val color = "#[0-9a-fA-F]{6}".toRegex()
}