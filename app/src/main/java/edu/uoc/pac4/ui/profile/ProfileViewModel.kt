package edu.uoc.pac4.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.uoc.pac4.data.oauth.AuthenticationRepository
import edu.uoc.pac4.data.user.UserRepository
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.java.KoinJavaComponent.inject


class ProfileViewModel(
        private val authentication: AuthenticationRepository,
        private val user: UserRepository
): ViewModel()
{

    val description: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun logout()
    {
        viewModelScope.launch {
            authentication.logout()
        }
    }

    fun updateDescription(description:String)
    {
        viewModelScope.launch {
            user.updateUser(description)
        }
    }

}