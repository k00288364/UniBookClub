package com.example.inventory.ui.event

import com.example.inventory.data.Event
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.inventory.data.EventsRepository

class EventEntryViewModel(private val eventsRepository: EventsRepository) : ViewModel() {
    var eventUiState by mutableStateOf(EventUiState())
        private set

    fun updateUiState(eventDetails: EventDetails) {
        eventUiState =
            EventUiState(eventDetails = eventDetails, isEntryValid = validateInput(eventDetails))
    }

    suspend fun saveEvent() {
        if (validateInput()) {
            eventsRepository.insertEvent(eventUiState.eventDetails.toEvent())
        }
    }

    private fun validateInput(uiState: EventDetails = eventUiState.eventDetails): Boolean {
        return with(uiState) {
            bookname.isNotBlank() && location.isNotBlank() && date.isNotBlank()
        }
    }
}

data class EventUiState(
    val eventDetails: EventDetails = EventDetails(),
    val isEntryValid: Boolean = false
)

data class EventDetails(
    val id: Int = 0,
    val bookname: String = "",
    val location: String = "",
    val date: String = "",
)

fun EventDetails.toEvent(): Event = Event(
    id = id,
    bookname = bookname,
    location = location,
    date = date
)
