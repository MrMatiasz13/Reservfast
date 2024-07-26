package pl.mrmatiasz.reservfastapp.module

import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseDatabaseModule {

    @Provides
    @Singleton
    fun firebaseClient(): Firebase {
        return Firebase
    }

    @Provides
    @Singleton
    fun firestore(client: Firebase): FirebaseFirestore {
        return client.firestore
    }
}