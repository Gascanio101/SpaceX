package com.example.spacex_v2.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacex_v2.data.CrewModel
import com.example.spacex_v2.data.RetrofitHelper
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    init {
        viewModelScope.launch {
//            _crew.value =
                if(RetrofitHelper.fetchData().getCrew().isSuccessful) {
                    _crew.value = RetrofitHelper.fetchData().getCrew().body()!!
                }
            else Log.d("gabs", "Error: ${RetrofitHelper.fetchData().getCrew().errorBody()}")
        }
    }

    private val _crew: MutableState<List<CrewModel.CrewModelItem>>
            = mutableStateOf(listOf())
    val crew = _crew

}