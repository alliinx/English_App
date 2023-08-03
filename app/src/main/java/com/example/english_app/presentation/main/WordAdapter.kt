package com.example.english_app.presentation.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.english_app.R
import com.example.english_app.data.model.WordEntity
import com.squareup.picasso.Picasso

class WordAdapter (
    private val applicationContext: Context
        ): RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private var words: List<WordEntity> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_words, parent, false)
        return WordViewHolder(view)
    }


    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val quote = words[position]
        holder.bind(quote, applicationContext)
    }

    override fun getItemCount(): Int = words.size

    fun setWords(w: List<WordEntity>) {
        this.words = w
        notifyDataSetChanged()
    }

    fun isEmpty(): Boolean {
        return words.isEmpty()
    }

    class WordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val word: TextView = view.findViewById(R.id.text_word)
        private val meaning: TextView = view.findViewById(R.id.text_meaning)
        private val imageWord: ImageView = view.findViewById(R.id.image_word)

        fun bind(currentWord: WordEntity, context: Context) {
            word.text = currentWord.word
            meaning.text = currentWord.meaning
            Picasso.with(context)
                .load(currentWord.image)
                .placeholder(R.mipmap.placeholder)
                .error(R.mipmap.placeholder_empty)
                .into(imageWord)
        }

    }
}

