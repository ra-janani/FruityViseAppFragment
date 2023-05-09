package com.example.fruityviseapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.viewModelScope
import com.example.fruityviseapp.data.FruityViceItemModel
import com.example.fruityvice.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FruitsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    //val fruits = MutableLiveData<ArrayList<FruityViceItemModel>>()

    private var _fruitsMutableLiveData = MutableLiveData<ArrayList<FruityViceItemModel>>()
    var fruitsLiveData  =_fruitsMutableLiveData.distinctUntilChanged()
    fun getFruitsData() {
        viewModelScope.launch {

            val result = repository.getFruits()
            _fruitsMutableLiveData.postValue(result)
        }
    }

}