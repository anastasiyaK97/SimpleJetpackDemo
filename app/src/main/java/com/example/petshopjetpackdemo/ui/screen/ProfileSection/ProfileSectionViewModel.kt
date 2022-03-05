package com.example.petshopjetpackdemo.ui.screen.ProfileSection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.petshopjetpackdemo.data.Category
import com.example.petshopjetpackdemo.data.CategoryRepository
import com.example.petshopjetpackdemo.data.OrdersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileSectionViewModel(
    ordersRepository: OrdersRepository,
    categoryRepository: CategoryRepository
) : ViewModel() {
    private val _orders: MutableStateFlow<List<Any>> =
        MutableStateFlow(ordersRepository.getOrders())
    val orders: StateFlow<List<Any>> get() = _orders

    private val _categories: MutableStateFlow<List<Category>> =
        MutableStateFlow(categoryRepository.getCategories())
    val categories: StateFlow<List<Category>> get() = _categories

    companion object {
        fun provideFactory(
            ordersRepository: OrdersRepository = OrdersRepository,
            categoryRepository: CategoryRepository = CategoryRepository
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ProfileSectionViewModel(ordersRepository, categoryRepository) as T
            }
        }
    }

}