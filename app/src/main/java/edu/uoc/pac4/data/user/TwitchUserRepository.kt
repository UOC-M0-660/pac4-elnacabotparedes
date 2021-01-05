package edu.uoc.pac4.data.user

import edu.uoc.pac4.data.TwitchApiDataSource

/**
 * Created by alex on 11/21/20.
 */

class TwitchUserRepository(
    // TODO: Add any datasources you may need
    private val dataSource: TwitchApiDataSource
) : UserRepository {

    override suspend fun getUser(): User? {
        return dataSource.getUser()
    }

    override suspend fun updateUser(description: String): User? {
        return dataSource.updateUserDescription(description)
    }
}