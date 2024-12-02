package com.example.myfirstapplication.data.model.controller


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstapplication.data.model.ServiceEntity
import com.example.myfirstapplication.data.model.ServiceModel
import com.example.myfirstapplication.data.model.dao.ServiceDao
import com.example.myfirstapplication.data.model.network.RetrofitClient
import com.example.myfirstapplication.data.model.toServiceEntity
import com.example.myfirstapplication.data.model.toServiceEntityList
import com.example.myfirstapplication.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
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

    fun showService(db: AppDatabase, id: Int, onResult: (ServiceEntity?) -> Unit) {
        val serviceDao = db.serviceDao()
        viewModelScope.launch {
            try {
                val response = api.getService(id) // Obtener el servicio desde la API
                if (response.isSuccessful) {
                    val serviceModel = response.body()
                    if (serviceModel != null) {
                        val serviceEntity = serviceModel.toServiceEntity()
                        withContext(Dispatchers.IO) {
                            try {
                                serviceDao.insertAll(listOf(serviceEntity)) // Guardar en la base de datos
                            } catch (exception: Exception) {
                                Log.d("error", "Insert failed: ${exception.message}")
                            }
                        }
                    }
                }
                // Recuperar desde la base de datos local
                val entity = withContext(Dispatchers.IO) {
                    serviceDao.show(id)
                }
                onResult(entity) // Retornar la entidad encontrada
            } catch (exception: Exception) {
                Log.d("error", "API call failed: ${exception.message}")
                onResult(null) // Retornar null en caso de error
            }
        }
    }

    fun createService(service: ServiceModel, onResult: (Response<ServiceModel>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = api.createService(service)
                onResult(response)
            } catch (exception: Exception) {
                Log.e("createService", "Error: ${exception.message}")
                // Si ocurre un error de red o cualquier otro problema, lo mostramos
                onResult(Response.error(500, ResponseBody.create(null, "Error en la solicitud")))
            }
        }
    }

    // En tu ViewModel
    fun getServiceById(serviceId: Int, onResult: (Response<ServiceModel>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = api.getServiceById(serviceId) // Llamada a la API para obtener el servicio por ID
                onResult(response)
            } catch (exception: Exception) {
                Log.e("getServiceById", "Error: ${exception.message}")
                onResult(Response.error(500, ResponseBody.create(null, "Error en la solicitud")))
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
