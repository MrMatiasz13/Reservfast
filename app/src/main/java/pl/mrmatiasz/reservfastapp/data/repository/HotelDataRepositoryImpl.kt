package pl.mrmatiasz.reservfastapp.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import pl.mrmatiasz.reservfastapp.data.model.Hotel
import pl.mrmatiasz.reservfastapp.domain.repository.HotelDataRepository
import pl.mrmatiasz.reservfastapp.util.Resource
import javax.inject.Inject

class HotelDataRepositoryImpl @Inject constructor(
    private val firebaseFirestore: FirebaseFirestore
): HotelDataRepository {
    override suspend fun getAll(): Flow<Resource<List<Hotel>>> {
        return flow {
            emit(Resource.Loading())
            val result = firebaseFirestore.collection("hotels")
                .get()
                .await()
            emit(Resource.Success(result.documents.mapNotNull { it.toObject(Hotel::class.java) }))
        }.catch {
            emit(Resource.Error(it.message.toString()))
            Log.w(TAG, "Error getting documents", it)
        }
    }
}