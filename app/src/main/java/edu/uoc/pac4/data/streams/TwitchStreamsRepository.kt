package edu.uoc.pac4.data.streams

import android.util.Log
import android.widget.Toast
import edu.uoc.pac4.R
import edu.uoc.pac4.data.TwitchApiDataSource
import io.ktor.http.content.MultiPartData

/**
 * Created by alex on 11/21/20.
 */

class TwitchStreamsRepository(
    // TODO: Add any datasources you may need
    private val dataSource: TwitchApiDataSource
) : StreamsRepository {

    override suspend fun getStreams(cursor: String?): Pair<String?, List<Stream>> {

        dataSource.getStreams(cursor)?.let { response ->
            return Pair(response.pagination?.cursor, response.data.orEmpty())
        }
        return Pair(" ", emptyList())
    }

}