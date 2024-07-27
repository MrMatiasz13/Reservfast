package pl.mrmatiasz.reservfastapp.domain.repository

import pl.mrmatiasz.reservfastapp.data.model.Hotel
import java.util.concurrent.Flow

interface HotelDataRepository {
    suspend fun getAll():
}