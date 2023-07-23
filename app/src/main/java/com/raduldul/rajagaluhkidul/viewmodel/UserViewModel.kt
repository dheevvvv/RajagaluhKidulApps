package com.raduldul.rajagaluhkidul.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raduldul.rajagaluhkidul.database_room.UserDAO
import com.raduldul.rajagaluhkidul.database_room.UserData
import com.raduldul.rajagaluhkidul.datastore_preferences.UserManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(val userDAO: UserDAO,val userManager: UserManager): ViewModel() {

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _userId = MutableLiveData<Int>()
    val userId: LiveData<Int> = _userId

    fun getUsername() {
        viewModelScope.launch {
            val username = userManager.getUsername()
            _username.postValue(username)
        }
    }

    fun getEmail(){
        viewModelScope.launch {
            val email = userManager.getEmail()
            _email.postValue(email)
        }
    }

    fun getUserId(email: String){
        GlobalScope.launch {
            val userId = userDAO.getUserIdByEmail(email)
            _userId.postValue(userId)
        }
    }

    fun insertUser(userData: UserData){
        GlobalScope.async {
            userDAO.insertUser(userData)
        }
    }
    fun checkUser(email : String, password : String) : LiveData<UserData> = userDAO.checkUser(email, password)


    fun updateUser(userData: UserData){
        GlobalScope.async {
            userDAO.updateUser(userData)
        }
    }

    fun getUser(): LiveData<UserData> {
        return userDAO.getUser()
    }
}