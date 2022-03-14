package me.krasnova.common.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import example.imageviewer.view.Clickable
import me.krasnova.common.style.iconPersonalAccount
import me.krasnova.common.style.iconPhoneAccount
import me.krasnova.common.theme.BlackText
import me.krasnova.common.theme.Fonts
import me.krasnova.common.theme.TopBarBackground

@Composable
fun TitleBar(text: String) {
    TopAppBar(
        backgroundColor = TopBarBackground,
        title = {
            Row(Modifier.height(50.dp)) {
                Text(
                    text,
                    color = BlackText,
                    fontFamily = Fonts.montserrat(),
                    fontSize = 24.sp,
                    modifier = Modifier.weight(1f).align(Alignment.CenterVertically)
                )
                Surface(
                    color = Color.Transparent,
                    modifier = Modifier.padding(end = 20.dp).align(Alignment.CenterVertically),
                    shape = CircleShape
                ) {
                    Clickable(
                        onClick = { /*todo*/ }
                    ) {
                        Image(
                            iconPhoneAccount(),
                            contentDescription = null,
                            modifier = Modifier.size(21.dp)
                        )
                    }
                }
                Surface(
                    color = Color.Transparent,
                    modifier = Modifier.padding(end = 16.dp).align(Alignment.CenterVertically),
                    shape = CircleShape
                ) {
                    Clickable(
                        onClick = { /*todo*/ }
                    ) {
                        Image(
                            iconPersonalAccount(),
                            contentDescription = null,
                            modifier = Modifier.size(21.dp)
                        )
                    }
                }
            }
        })
}