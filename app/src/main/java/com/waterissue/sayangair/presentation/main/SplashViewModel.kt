package com.waterissue.sayangair.presentation.main

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waterissue.sayangair.domain.repository.DataStoreRepository
import com.waterissue.sayangair.presentation.main.component.Screen
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.M)
class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository,
    private val connectivityManager: ConnectivityManager
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(Screen.Welcome.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            if (isNetworkConnected()) {
                repository.readOnBoardingState().collect { completed ->
                    if (completed) {
                        _startDestination.value = Screen.Home.route
                    } else {
                        _startDestination.value = Screen.Welcome.route
                    }
                }
            } else {
                _isLoading.value = false
            }

            _isLoading.value = false
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun isNetworkConnected(): Boolean {
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val activeNetworkInfo = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

        return when {
            activeNetworkInfo.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetworkInfo.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }
}
