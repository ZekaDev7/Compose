package com.example.composelesson.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composelesson.entity.FoodsData
import com.example.composelesson.repo.FoodsRepository

class FoodsViewModel: ViewModel() {
    var foodList = MutableLiveData<List<FoodsData>>()
    var repo = FoodsRepository()

    init {
        loadFoods()
        foodList = repo.bringFoods()
    }

    fun loadFoods() {
        repo.getAllFoods()
    }
}