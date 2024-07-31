package pl.mrmatiasz.reservfastapp.presentation.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pl.mrmatiasz.reservfastapp.data.model.Hotel
import pl.mrmatiasz.reservfastapp.domain.repository.HotelDataRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val hotelDataRepository: HotelDataRepository
): ViewModel() {
    private var _hotelsList = MutableStateFlow<List<Hotel>>(emptyList())
    val hotelsList = _hotelsList.asStateFlow()

    init {
        fetchHotelsData()
    }

    private fun fetchHotelsData() {
        viewModelScope.launch {
            hotelDataRepository.getAll().collect { result ->
                _hotelsList.value = result.data ?: emptyList()
            }
        }
    }
}