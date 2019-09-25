package com.example.architecturecomponent.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.architecturecomponent.R
import com.example.architecturecomponent.model.Word

class WordListAdapter(private val mContext: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private lateinit var mWords: List<Word>

    fun getWords(words: List<Word>){
        mWords = words
        notifyDataSetChanged()
    }

    interface ItemClickListener {
        fun onItemClick(view:View, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return mWords.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        var currentWord = mWords[position]
        holder.wordTextView.text = currentWord.name
    }

    class WordViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var wordTextView: TextView = itemView.findViewById(R.id.textView)
    }
}