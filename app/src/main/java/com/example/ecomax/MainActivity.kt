package com.example.ecomax

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.ecomax.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        var arraylistCity = ArrayList<String>()
        arraylistCity.add("New Delhi")
        arraylistCity.add("Banglore")
        arraylistCity.add("Chennai")
        arraylistCity.add("Lucknow")
        CoroutineScope(Dispatchers.IO).launch {
            var apiService = RetrofitImple.getInstance()
            var response = apiService.getData("New Delhi","4dd79c02aff94ebab1a190013232512")

            withContext(Dispatchers.Main)
            {
                if (response!!.isSuccessful)
                {
                    Log.e("success",response.toString())
                    activityMainBinding.textViewData.text=response.body().toString()
                }
            }
        }
    }
}