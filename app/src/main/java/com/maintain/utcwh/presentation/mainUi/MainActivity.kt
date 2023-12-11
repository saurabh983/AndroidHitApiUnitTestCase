package com.maintain.utcwh.presentation.mainUi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.maintain.utcwh.R
import com.maintain.utcwh.presentation.State
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            delay(500)
            viewModel.loadUserData()
            viewModel.userFlow.collect {
                when(it) {
                    is State.Success -> Log.i("ApiResult", "success ${it.data}")
                    is State.Error -> Log.i("ApiResult", "success ${it.error}")
                    is State.Loading -> Log.i("ApiResult", "loading")
                }
            }
        }
    }
}