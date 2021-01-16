package edu.uoc.pac4.ui.profile

import androidx.lifecycle.*
import edu.uoc.pac4.data.oauth.AuthenticationRepository
import edu.uoc.pac4.data.user.User
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

    private val userInfo = MediatorLiveData<User>()

    fun getUserInfo(): LiveData<User> = userInfo

    fun logout()
    {
        viewModelScope.launch {
            authentication.logout()
        }
    }

    fun updateDescription(description:String)
    {
        viewModelScope.launch {
           userInfo.postValue(user.updateUser(description))
        }
    }


    fun getUserProfile()
    {
        viewModelScope.launch {
            userInfo.postValue(user.getUser())
        }
    }



}