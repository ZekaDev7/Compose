package com.example.composelesson.repo

import androidx.lifecycle.MutableLiveData
import com.example.composelesson.entity.FoodsData

class FoodsRepository {
    var foodsList = MutableLiveData<List<FoodsData>>()

    init {
        foodsList = MutableLiveData()
    }

    fun bringFoods(): MutableLiveData<List<FoodsData>> {
        return foodsList
    }

    fun getAllFoods() {
        val list = mutableListOf<FoodsData>()

        val f1 = FoodsData(1, "Kofte", "kofte", 10)
        val f2 = FoodsData(2, "Fries", "fries", 4)
        val f3 = FoodsData(3, "Pizza", "pizza", 13)
        val f4 = FoodsData(4, "Doner", "doner", 3)
        val f5 = FoodsData(5, "Lahmacun", "lahmacun", 5)
        val f6 = FoodsData(6, "Ayran", "ayran", 1)
        val f7 = FoodsData(6, "Ayran", "ayran", 1)
        val f8 = FoodsData(6, "Ayran", "ayran", 1)

        list.add(f1)
        list.add(f2)
        list.add(f3)
        list.add(f4)
        list.add(f5)
        list.add(f6)
        list.add(f7)
        list.add(f8)

        foodsList.value = list
    }
}