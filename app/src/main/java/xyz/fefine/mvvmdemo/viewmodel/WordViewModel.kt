package xyz.fefine.mvvmdemo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.fefine.mvvmdemo.model.Word
import xyz.fefine.mvvmdemo.model.WordRoomDatabase
import xyz.fefine.mvvmdemo.repository.WordRepository

class WordViewModel(application: Application): AndroidViewModel(application) {

    private val repository: WordRepository

    val allWord: LiveData<List<Word>>

    init {
        val wordDao = WordRoomDatabase.getDatabase(application).wordDao()
        repository = WordRepository(wordDao)

        allWord  = repository.allWords
    }

    fun addWord(word: Word) = viewModelScope.launch {
        repository.addWord(word)
    }

}