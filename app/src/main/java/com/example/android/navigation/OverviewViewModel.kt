package com.example.android.navigation



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the request status String
    val response: LiveData<String>
        get() = _response

    private val _property =  MutableLiveData<MarsProperty>()

    val property:LiveData<MarsProperty>
        get() = _property
    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(
            viewModelJob + Dispatchers.Main)

    init {
        getMarsRealEstateProperties()
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    private fun getMarsRealEstateProperties() {

        coroutineScope.launch{
            var getPropertiesDeferred = MarsApi.retrofitService.getProperties("e42f83dd","housefull4", "2019")
            try{
                var listResult = getPropertiesDeferred.await()
                _response.value = "Success:${listResult} Mars properties retrieved"
                // if(listResult.size > 0)
                //{
                _property.value = listResult
                //}
            }catch(e:Exception){
                _response.value = "Failure:${e.message}"
            }

        }
    }
}
