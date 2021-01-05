package edu.uoc.pac4.data.streams

import android.util.Log
import edu.uoc.pac4.data.TwitchApiDataSource

/**
 * Created by alex on 11/21/20.
 */

class TwitchStreamsRepository(
    // TODO: Add any datasources you may need
    private val dataSource: TwitchApiDataSource
) : StreamsRepository {

    override suspend fun getStreams(cursor: String?): Pair<String?, List<Stream>> {
        TODO("Not yet implemented")
    }

    override fun hello(): String {
        Log.d("TAG", "HELLO");
        return "heloo"
    }

}