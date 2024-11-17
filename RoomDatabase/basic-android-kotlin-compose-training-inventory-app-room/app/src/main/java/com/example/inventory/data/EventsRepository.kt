/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import android.app.usage.UsageEvents.Event
import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 */
interface EventsRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllEventsStream(): Flow<List<Event>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getEventStream(id: Int): Flow<Event?>

    /**
     * Insert item in the data source
     */
    suspend fun insertEvent(event: com.example.inventory.data.Event)

    /**
     * Delete item from the data source
     */
    suspend fun deleteEvent(event: Event)

    /**
     * Update item in the data source
     */
    suspend fun updateEvent(event: Event)
}

