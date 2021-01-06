package edu.uoc.pac4.ui.streams

import androidx.lifecycle.*
import edu.uoc.pac4.data.streams.Stream
import edu.uoc.pac4.data.streams.StreamsRepository
import kotlinx.coroutines.launch

class StreamsViewModel(
    private val streamsRepository: StreamsRepository
): ViewModel()
{

    private val streams = MutableLiveData<Pair<String?, List<Stream>>>()

    init {
        getAllStreams()
    }

    fun getStreams(): LiveData<Pair<String?, List<Stream>>> = streams

    fun getAllStreams()
    {
        viewModelScope.launch {
            streams.postValue(streamsRepository.getStreams())
        }
    }


}