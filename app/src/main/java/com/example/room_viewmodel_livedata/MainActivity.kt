package com.example.room_viewmodel_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.room_viewmodel_livedata.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.lifecycleOwner = this //LiveData 때문에

        val viewmodel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))[MainViewModel::class.java]
        binding.viewModel = viewmodel

        /*viewmodel.getAll().observe(this, Observer {//UI에서 값이 변화하는 것을 관찰하는데 데이터 바인딩으로 xml에 데이터를 직접 수정하고 나타내면 필요없음
            result_text.text = it.toString()
        })MainViewModel로 DataBinding 옮김*/

        /*add_button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {//코틀린에서는 코루틴 방식으로 AsyncTask를 사용하지않고 쉽게 BackgroundTask에서 돌아가게한다
                viewmodel.insert(name_edittext.text.toString())
            }
        }MainViewModel로 DataBinding 옮김*/
    }
}