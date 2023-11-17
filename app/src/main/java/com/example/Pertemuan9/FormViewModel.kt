package com.example.Pertemuan9

import androidx.lifecycle.ViewModel
import com.example.Pertemuan9.data.FormUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FormViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(FormUIState())
    val stateUI: StateFlow<FormUIState> = _stateUI.asStateFlow()

    fun setBiodata(list: MutableList<String>) {
        _stateUI.update {
                stateSaatIni -> stateSaatIni.copy(
                    nama = list[0],
                    nim = list[1],
                    konsentrasi = list[2],
                    judul = list[3]
                )
        }
    }

    fun setDospemSatu(dosenPilihan: String) {
        _stateUI.update { stateStateIni ->
            stateStateIni.copy(dospemsatu = dosenPilihan)
        }
    }

    fun setDospemDua(dosenPilihan: String) {
        _stateUI.update {stateStateIni ->
            stateStateIni.copy(dospemdua = dosenPilihan)
        }
    }

    fun resetForm() {
        _stateUI.value = FormUIState()
    }
}