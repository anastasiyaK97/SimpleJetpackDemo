import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.window.*
import me.krasnova.common.DesktopAppState
import me.krasnova.common.style.icAppRounded
import me.krasnova.common.DesktopApp
import me.krasnova.common.utils.getPreferredWindowSize

fun main() = application {

    val content = remember {
        DesktopAppState()
    }

    val icon = icAppRounded()

    Window(
        onCloseRequest = ::exitApplication,
        title = "Petshop Jetpack Compose",
        state = WindowState(
            position = WindowPosition.Aligned(Alignment.Center),
            size = getPreferredWindowSize(800, 1000)
        ),
        icon = icon
    ) {
        MaterialTheme {
            DesktopApp(content)
        }
    }
}