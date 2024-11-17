package com.example.inventory.ui.event

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.inventory.BookClubTopAppBar
import com.example.inventory.R
import com.example.inventory.data.Event
import com.example.inventory.ui.navigation.NavigationDestination
import com.example.inventory.ui.theme.BookClubTheme

object EventDetailsDestination : NavigationDestination {
    override val route = "event_details"
    override val titleRes = R.string.event_detail_title
    const val eventIdArg = "eventId"
    val routeWithArgs = "$route/{$eventIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailsScreen(
    navigateToEditEvent: (Int) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            BookClubTopAppBar(
                title = stringResource(EventDetailsDestination.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateToEditEvent(0) },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = stringResource(R.string.edit_event_title),
                )
            }
        }, modifier = modifier
    ) { innerPadding ->
        EventDetailsBody(
            eventDetailsUiState = EventDetailsUiState(),
            modifier = Modifier
                .padding(
                    start = innerPadding.calculateStartPadding(LocalLayoutDirection.current),
                    end = innerPadding.calculateEndPadding(LocalLayoutDirection.current),
                    top = innerPadding.calculateTopPadding()
                )
                .verticalScroll(rememberScrollState())
        )
    }
}

@Composable
private fun EventDetailsBody(
    eventDetailsUiState: EventDetailsUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        EventDetails(
            event = eventDetailsUiState.eventDetails,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun EventDetails(
    event: Event, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier, colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
        ) {
            EventDetailsRow(
                labelResID = R.string.event,
                eventDetail = event.bookname,
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
            )
            EventDetailsRow(
                labelResID = R.string.location,
                eventDetail = event.location,
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
            )
            EventDetailsRow(
                labelResID = R.string.date,
                eventDetail = event.date,
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
            )
        }
    }
}

@Composable
private fun EventDetailsRow(
    @StringRes labelResID: Int, eventDetail: String, modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(stringResource(labelResID))
        Spacer(modifier = Modifier.weight(1f))
        Text(text = eventDetail, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun EventDetailsScreenPreview() {
    BookClubTheme {
        EventDetailsBody(
            eventDetailsUiState = EventDetailsUiState(
                eventDetails = Event(1, "Call Of Cthulu", "TUS Library", "22-11-2024")
            )
        )
    }
}

data class EventDetailsUiState(
    val eventDetails: Event = Event(0, "", "", ""),
    val meetUp: Boolean = false
)

data class Event(
    val id: Int,
    val bookname: String,
    val location: String,
    val date: String
)
