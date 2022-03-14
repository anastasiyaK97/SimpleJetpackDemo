package me.krasnova.common.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import javax.imageio.ImageIO
import org.jetbrains.skia.Image
import java.io.ByteArrayOutputStream
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

@Composable
actual fun networkImagePainter(url: String): Painter {
    try {
        val url = URL(url)
        val connection = url.openConnection() as HttpURLConnection
        connection.connect()

        val inputStream = connection.inputStream
        val bufferedImage = ImageIO.read(inputStream)

        val stream = ByteArrayOutputStream()
        ImageIO.write(bufferedImage, "png", stream)
        val byteArray = stream.toByteArray()

        val imageBitmap = Image.makeFromEncoded(byteArray).asImageBitmap()

        return BitmapPainter(imageBitmap)
    } catch (e: Exception) {
        e.printStackTrace()
        return painterResource("images/empty.png")
    }
}