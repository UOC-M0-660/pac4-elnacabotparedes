package edu.uoc.pac4.data

import android.util.Log
import edu.uoc.pac4.data.oauth.OAuthTokensResponse
import edu.uoc.pac4.data.streams.StreamsResponse
import edu.uoc.pac4.data.user.User
import io.ktor.client.HttpClient


interface TwitchApiDataSource {
    suspend fun getTokens(authorizationCode: String): OAuthTokensResponse?
    suspend fun getStreams(cursor: String? = null): StreamsResponse?
    suspend fun getUser(): User?
    suspend fun updateUserDescription(description: String): User?
}