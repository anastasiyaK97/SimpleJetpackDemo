package me.krasnova.common.ui.screen.profile

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import me.krasnova.common.data.ProfileRepository
import me.krasnova.common.model.ProfileSection
import me.krasnova.common.ui.screen.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModel(
    private val profileRepository: ProfileRepository,
    private val navHostController: NavHostController,
    private val navBackStackEntry: NavBackStackEntry
) : ViewModel() {

    private val _uiState = MutableLiveData<UiProfileState>(UiProfileState.Loading)
    val uiState: LiveData<UiProfileState>
        get() = _uiState

    private val _profileSections: MutableStateFlow<List<ProfileSection>> =
        MutableStateFlow(emptyList())
    val profileSection: StateFlow<List<ProfileSection>> get() = _profileSections

    fun updateData() {
        _profileSections.value = profileRepository.getSections()
        _uiState.value = UiProfileState.Success
    }

    fun navigateToProfileSection(section: ProfileSection) {
        if (navBackStackEntry.lifecycleIsResumed()) {
            navHostController.navigate(Screen.ProfileSectionScreen.withArgs(section.name))
        }
    }

    private fun NavBackStackEntry.lifecycleIsResumed() =
        this.lifecycle.currentState == Lifecycle.State.RESUMED

    companion object {
        fun provideFactory(
            navHostController: NavHostController,
            navBackStackEntry: NavBackStackEntry,
            profileRepository: ProfileRepository = ProfileRepository
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ProfileViewModel(profileRepository, navHostController, navBackStackEntry) as T
            }
        }
    }
}

sealed class UiProfileState {
    object Loading : UiProfileState()
    object Error : UiProfileState()
    object Success : UiProfileState()
}