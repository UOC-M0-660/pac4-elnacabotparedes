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

    override suspend fun isUserAvailable(): Boolean
    {
        val sessionManager = SessionManager(context)
        return sessionManager.isUserAvailable()
    }

    override suspend fun login(authorizationCode: String): Boolean
    {
        dataSource.getTokens(authorizationCode)?.let { response ->

            val sessionManager = SessionManager(context)
            sessionManager.saveAccessToken(response.accessToken)
            response.refreshToken?.let {
                sessionManager.saveRefreshToken(it)
            }

            return true
        }

        return false
    }

    override suspend fun logout()
    {
        SessionManager(context).clearAccessToken()
        SessionManager(context).clearRefreshToken()
    }
}