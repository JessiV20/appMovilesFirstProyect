package com.example.myfirstapplication.data.model.controller


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstapplication.data.model.ServiceModel
import com.example.myfirstapplication.data.model.dao.ServiceDao
import com.example.myfirstapplication.data.model.network.RetrofitClient
import com.example.myfirstapplication.data.model.toServiceEntityList
import com.example.myfirstapplication.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class ServiceViewModel : ViewModel() {
    val api = RetrofitClient.api

    fun getServices(db: AppDatabase) {
        val serviceDao = db.serviceDao()
        viewModelScope . launch {
            try {
                val response = api.getServices()
                if (response.body()?.count()!! > 0) {
                    val serviceEntities = response.body()?.toServiceEntityList()
                    if (serviceEntities != null) {
                        CoroutineScope(Dispatchers.IO).launch {
                            try {
                                serviceDao.insertAll(serviceEntities)
                            } catch (exception: Exception) {
                                Log.d("error", exception.toString())
                            }
                        }
                    }
                }
            } catch (exception: Exception) {
                print(exception)
            }
        }
    }

    fun showService(id: Int, onResult: (Response<ServiceModel>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = api.getService(id)
                onResult(response)
            } catch (exception: Exception) {
                print(exception)
            }
        }
    }

    fun createService(service: ServiceModel, onResult: (Response<ServiceModel>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = api.createService(service)
                onResult(response)
            } catch (exception: Exception) {
                print(exception)
            }
        }
    }

    fun updateService(id: Int, service: ServiceModel, onResult: (Response<ServiceModel>) -> Unit) {
        try {
            viewModelScope.launch {
                val response = api.updateService(id, service)
                onResult(response)
            }
        } catch (exception: Exception) {
            print(exception)
        }
    }

    fun deleteService(id: Int, onResult: (Response<ServiceModel>) -> Unit) {
        try {
            viewModelScope.launch {
                val response = api.deleteService(id)
                onResult(response)
            }
        } catch (exception: Exception) {
            print(exception)
        }
    }
}
