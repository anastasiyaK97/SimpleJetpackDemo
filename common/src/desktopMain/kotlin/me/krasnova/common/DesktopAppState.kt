package me.krasnova.common

import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.krasnova.common.data.ProfileRepository
import me.krasnova.common.model.QuickCard
import me.krasnova.common.model.toQuickCardData

class DesktopAppState(
    private val profileRepository: ProfileRepository = ProfileRepository
) {
    private val isLoading = mutableStateOf(true)
    val sectionsCollection = mutableStateOf<List<QuickCard>>(emptyList())

    fun isLoading(): Boolean = isLoading.value

    private fun onContentReady() {
        isLoading.value = false
    }

    fun initData() {
        if (!isLoading.value) return
        CoroutineScope(Dispatchers.IO).launch(Dispatchers.IO) {
            sectionsCollection.value = profileRepository.getSections().map {
                QuickCard(quickCardData = it.toQuickCardData(), clickAction = {})
            }
            onContentReady()
        }
    }

}