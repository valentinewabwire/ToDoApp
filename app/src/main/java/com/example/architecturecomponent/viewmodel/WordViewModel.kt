package com.example.architecturecomponent.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.architecturecomponent.model.Word
import com.example.architecturecomponent.model.WordRepository

class WordViewModel(application: Application): AndroidViewModel(application) {
    private val wordRepository:WordRepository
    private val allWords: LiveData<List<Word>>

    init {
        wordRepository = WordRepository(application)
        allWords = wordRepository.getAllWords()
    }

    fun insertWord(word: Word){
        wordRepository.insertWord(word)
    }
    fun deleteWord(word: Word){
        wordRepository.deleteWord(word)
    }
    fun deleteAllWords(){
        wordRepository.deleteAllWords()
    }
    fun getAllWords() = allWords

    fun getWordByName(name:String): Word?{
        return wordRepository.getWordByName(name)
    }

}