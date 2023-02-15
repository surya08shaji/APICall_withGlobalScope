package com.example.globalscope.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.globalscope.Adapter
import com.example.globalscope.R
import com.example.globalscope.data.ApiInterface
import com.example.globalscope.data.Urls
import com.example.globalscope.data.model.ResponseModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerview.layoutManager = LinearLayoutManager(this)

        val quotesApi = Urls.getInstance().create(ApiInterface::class.java)
        GlobalScope.launch (Dispatchers.Main){
            val result = quotesApi.getQuotes()
            if (result != null)
                Log.d("Scopes: ", result.body().toString())

            val responseModel: ResponseModel? = result.body()
            val adapter = Adapter(responseModel?.results)
            recyclerview.adapter = adapter


        }



    }
}