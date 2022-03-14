package me.krasnova.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import me.krasnova.common.theme.TopBarBackground
import com.google.accompanist.insets.statusBarsPadding
import me.krasnova.common.R

@Composable
fun TopBar(
    title: String,
    backAction: () -> Unit,
    previousTitle: String? = null,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = Modifier
            .background(TopBarBackground)
            .fillMaxWidth()
            .wrapContentHeight()
            .statusBarsPadding()
            .clip(shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
            .padding(top = 16.dp, bottom = 8.dp)
    ) {
        val (text, icon1, icon2) = createRefs()
        TopAppBarLayout(title, backAction, previousTitle, Modifier.constrainAs(text) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(icon1.start)
            width = Dimension.fillToConstraints
        })
        AppBarIcon(
            iconResourceId = R.drawable.icon_phone_account,
            modifier = Modifier.constrainAs(icon1) {
                top.linkTo(parent.top)
                end.linkTo(icon2.start)
            }
        ) {  /*click*/ }
        AppBarIcon(
            iconResourceId = R.drawable.icon_personal_account,
            modifier = Modifier.constrainAs(icon2) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }
        ) {  /*click*/ }
    }
}

@Composable
fun TopAppBarLayout(title: String, backAction: () -> Unit, previousTitle: String?, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier.wrapContentHeight()
    ) {
        if (previousTitle != null) {
            PreviousTitle(previousTitle, backAction)
        }
        Text(text = title, style = MaterialTheme.typography.h1, modifier = Modifier.padding(start = 16.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar(
        title = stringResource(id = R.string.top_bar_personal_account_title),
        backAction = {},
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    )
}