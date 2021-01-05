package edu.uoc.pac4.data.oauth

import android.content.Context
import edu.uoc.pac4.data.SessionManager
import edu.uoc.pac4.data.TwitchApiDataSource

/**
 * Created by alex on 11/21/20.
 */
class OAuthAuthenticationRepository(
    // TODO: Add any datasources you may need
    private val dataSource: TwitchApiDataSource,
    private val context: Context
) : AuthenticationRepository {

    override suspend fun isUserAvailable(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun login(authorizationCode: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun logout()
    {
        SessionManager(context).clearAccessToken()
        SessionManager(context).clearRefreshToken()
    }
}