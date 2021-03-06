package edu.uoc.pac4.ui.di

import edu.uoc.pac4.ui.LaunchViewModel
import edu.uoc.pac4.ui.profile.ProfileViewModel
import edu.uoc.pac4.ui.streams.StreamsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by alex on 11/21/20.
 */

val uiModule = module {
    // TODO: Init your UI Dependencies

    // LaunchViewModel example
    viewModel { LaunchViewModel(repository = get()) }

    viewModel {ProfileViewModel(authentication = get(), user = get())}

    viewModel { StreamsViewModel(streamsRepository = get()) }
}