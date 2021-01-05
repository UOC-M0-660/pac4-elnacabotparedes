package edu.uoc.pac4.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import edu.uoc.pac4.R
import edu.uoc.pac4.ui.login.LoginActivity
import edu.uoc.pac4.data.SessionManager
import edu.uoc.pac4.data.oauth.AuthenticationRepository
import edu.uoc.pac4.ui.streams.StreamsActivity
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LaunchActivity : AppCompatActivity(), KoinComponent {

    private val oauthAuthRepository by inject<AuthenticationRepository>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        checkUserSession()
    }

    private fun checkUserSession() {

        lifecycleScope.launch {
            oauthAuthRepository.isUserAvailable()?.let { response ->
                if(response)
                {
                    goToStreams()
                }
                else
                {
                    goToLogin()
                }
            }
        }
        finish()
    }

    private fun goToStreams()
    {
        startActivity(Intent(this, StreamsActivity::class.java))
    }

    private fun goToLogin()
    {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}