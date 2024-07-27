package pl.mrmatiasz.reservfastapp.domain.repository

import kotlinx.coroutines.flow.Flow
import pl.mrmatiasz.reservfastapp.data.model.Hotel
import pl.mrmatiasz.reservfastapp.util.Resource

interface HotelDataRepository {
    suspend fun getAll(): Flow<Resource<List<Hotel>>>
}