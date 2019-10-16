package xyz.fefine.mvvmdemo.repository

import androidx.lifecycle.LiveData
import xyz.fefine.mvvmdemo.model.Word
import xyz.fefine.mvvmdemo.model.WordDao

class WordRepository(private val dao: WordDao) {

    val allWords: LiveData<List<Word>> = dao.getAllWords()

    suspend fun addWord(word: Word) {
        dao.addWord(word)
    }
}