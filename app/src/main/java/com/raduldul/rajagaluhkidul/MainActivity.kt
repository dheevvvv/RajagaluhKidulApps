package com.raduldul.rajagaluhkidul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.raduldul.rajagaluhkidul.datastore_preferences.UserManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var userManager: UserManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userManager = UserManager.getInstance(this)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        lifecycleScope.launch {
            if (userManager.isLoggedIn().first()){
                super.onBackPressed() // Perilaku "back" default ketika dalam sesi login
            }
            else{
                moveTaskToBack(true)  // Keluar dari aplikasi ketika sudah logout
            }
        }
    }
}