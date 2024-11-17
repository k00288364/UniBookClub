package com.example.inventory.ui.event

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * ViewModel to retrieve, update and delete an item from the [EventsRepository]'s data source.
 */
class EventDetailsViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val eventId: Int = checkNotNull(savedStateHandle[EventDetailsDestination.eventIdArg])

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * UI state for ItemDetailsScreen
 */
data class EventDetailsUiState(
    val eventDetails: EventDetails = EventDetails(),
    val meetUp: Boolean = false
)

