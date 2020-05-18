package com.kienht.gapo.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kienht.gapo.auth.domain.LoginUseCase
import com.kienht.gapo.core.common.DataState
import com.kienht.gapo.shared.qualifier.CoDispatcherIOQualifier
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author kienht
 */
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    @CoDispatcherIOQualifier private val executor: CoroutineDispatcher
) : ViewModel() {

    val phoneNumberLiveData = MutableLiveData<String>()

    val isShowLoadingLiveData: LiveData<Boolean>
        get() = _isShowLoadingLiveData
    private val _isShowLoadingLiveData = MutableLiveData<Boolean>(false)

    val loginStateLiveData: LiveData<DataState<*>>
        get() = _loginStateLiveData
    private val _loginStateLiveData = MutableLiveData<DataState<*>>()

    /**
     * Kiểm tra xem đã login hay chưa?
     */
    init {
        if (loginUseCase.isLoggedIn) {
            _loginStateLiveData.value = DataState.COMPLETE
        }
    }

    fun login() {
        val phone = phoneNumberLiveData.value
        if (!phone.isNullOrEmpty()) {
            viewModelScope.launch {
                _isShowLoadingLiveData.value = true
                delay(2000)
                withContext(executor) {
                    try {
                        loginUseCase(phone)
                        _loginStateLiveData.postValue(DataState.COMPLETE)
                    } catch (e: Exception) {
                        _loginStateLiveData.postValue(DataState.ERROR(e))
                    }
                }
            }
        }
    }
}