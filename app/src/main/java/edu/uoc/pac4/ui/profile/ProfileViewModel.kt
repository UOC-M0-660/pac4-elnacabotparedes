package edu.uoc.pac4.ui.profile

import androidx.lifecycle.ViewModel
import edu.uoc.pac4.data.oauth.AuthenticationRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.java.KoinJavaComponent.inject


class ProfileViewModel(
        private val repository: AuthenticationRepository
): ViewModel()
{


}