package edu.uoc.pac4.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import edu.uoc.pac4.R
import edu.uoc.pac4.ui.login.LoginActivity
import edu.uoc.pac4.data.SessionManager
import edu.uoc.pac4.data.oauth.AuthenticationRepository
import edu.uoc.pac4.ui.streams.StreamsActivity
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LaunchActivity : AppCompatActivity(), KoinComponent {

   private val launchViewModel: LaunchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        launchViewModel.getUserAvailability()
        checkUserSession()

    }

    private fun checkUserSession() {


        if(launchViewModel.isUserAvailable.value!!)
        {
                startActivity(Intent(this, StreamsActivity::class.java))
        }
        else
        {
                startActivity(Intent(this, LoginActivity::class.java))
        }
        finish()
    }
}