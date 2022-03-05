package com.example.petshopjetpackdemo.ui.screen.ProfileSection

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.petshopjetpackdemo.R
import com.example.petshopjetpackdemo.data.toQuickCardData
import com.example.petshopjetpackdemo.model.QuickCard
import com.example.petshopjetpackdemo.ui.components.QuickCardGrid
import com.example.petshopjetpackdemo.ui.theme.Grey
import com.example.petshopjetpackdemo.ui.theme.PetshopTheme
import com.example.petshopjetpackdemo.ui.theme.White

@Composable
fun ProfileSectionScreen(
    viewModel: ProfileSectionViewModel = viewModel(factory = ProfileSectionViewModel.provideFactory())
) {
    val orders by viewModel.orders.collectAsState()
    val categories by viewModel.categories.collectAsState()

    Column(
        modifier = Modifier
            .background(PetshopTheme.colors.uiBackground)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (orders.isEmpty()) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = stringResource(id = R.string.orders_empty_title), style = MaterialTheme.typography.h1)
            Spacer(modifier = Modifier.height(6.dp))
            QuickCardGrid(
                cardsCollection = categories.map { QuickCard(quickCardData = it.toQuickCardData(), clickAction = {}) },
                cardHeightDp = 126
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier
                    .height(42.dp)
                    .fillMaxWidth()
                    .shadow(elevation = 0.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = White),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Grey),
                onClick = {}
            ) {
                Text(text = stringResource(id = R.string.orders_empty_button_title), style = MaterialTheme.typography.button)
            }
        }
    }
}
