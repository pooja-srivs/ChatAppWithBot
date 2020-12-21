package com.example.docsappassignment.chat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.docsappassignment.data.database.ChatData
import com.example.docsappassignment.data.remote.sources.ChatDataModel
import com.example.docsappassignment.data.repository.DataRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ChatViewModel(private val dataRepository: DataRepository) : ViewModel() {

    var messagesLiveData : MutableLiveData<ChatDataModel> = MutableLiveData()

    var errorLiveData : MutableLiveData<Throwable> = MutableLiveData()
    var isLoading : MutableLiveData<Boolean> = MutableLiveData()
    private val compositeDisposable : CompositeDisposable = CompositeDisposable()

    fun getNearbyPlaces(message: String) {
        isLoading.value = true
        dataRepository.getNearbyPlaceData(message)
             .subscribeOn(Schedulers.io())
             .subscribe({chatData ->
                 isLoading.postValue(false)
                 messagesLiveData.postValue(chatData)

                 insertItem(chatData.message?.message?: "")
                 },
                 {
                     errorLiveData.postValue(it)
                     isLoading.postValue(false)
                 }).let {
                compositeDisposable.add(it)
            }
     }

    fun insertItem(message: String) {
        dataRepository.insertOrUpdate(ChatData(message = message))
    }

    fun getAllChatDataData() : List<ChatData>{
        return dataRepository.getAllChatDataPlacesData()
    }

    override fun onCleared() {
        super.onCleared()
        if (compositeDisposable != null){
            compositeDisposable.clear()
        }
    }
}