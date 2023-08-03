package com.example.english_app

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.english_app.data.model.WordEntity
import com.example.english_app.databinding.ActivityDictionaryBinding
import com.example.english_app.presentation.main.WordAdapter
import com.example.english_app.presentation.main.WordViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProviders
import com.example.english_app.data.repository.WordRepository
import com.example.english_app.presentation.main.WordViewModelFactory
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.android.get

class DictionaryActivity:AppCompatActivity() {

    private lateinit var binding: ActivityDictionaryBinding

    private lateinit var wordViewModel: WordViewModel
    private lateinit var wordViewModelFactory: WordViewModelFactory
    private lateinit var recyclerView: RecyclerView
    private val wordAdapter = WordAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDictionaryBinding.inflate(layoutInflater)

        recyclerView = binding.words
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = wordAdapter

        //wordViewModel = ViewModelProvider(this)[WordViewModel::class.java]

        /*wordViewModel.words.observe(this, Observer<List<WordEntity>> { t ->
            wordAdapter.setWords(t ?: emptyList())
        })*/

        wordViewModelFactory = WordViewModelFactory(
            WordRepository(this, Dispatchers.IO), this
        )

        wordViewModel =
            ViewModelProvider(this, wordViewModelFactory).get(WordViewModel::class.java)

        wordViewModel.getWords().observe(this, Observer {words->
            words?.let { wordAdapter.setWords(it) }
        })

//        wordViewModel.getWords().observe(this, Observer { words ->
//            // Update the cached copy of the words in the adapter.
//            words?.let { wordAdapter.setWords(it) }
//        })

        setContentView(binding.root)
    }
}