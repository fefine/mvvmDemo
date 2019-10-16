package xyz.fefine.mvvmdemo.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName = "word_table")
class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)

@Dao
interface WordDao {

    @Query("select * from word_table")
    fun getAllWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWord(word: Word)

    @Delete
    suspend fun deleteWord(word: Word)

    @Query("delete from word_table")
    suspend fun deleteAll()
}

// 注意版本变更
// https://medium.com/google-developers/understanding-migrations-with-room-f01e04b07929
@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase: RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            val  tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }

}