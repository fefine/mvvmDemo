package xyz.fefine.mvvmdemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import xyz.fefine.mvvmdemo.adapter.WordListAdapter
import xyz.fefine.mvvmdemo.model.Word
import xyz.fefine.mvvmdemo.viewmodel.WordViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var wordViewModel: WordViewModel
     private lateinit var dataBinding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        dataBinding = DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_main)
        dataBinding.lifecycleOwner = this

        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }

        val adapter = WordListAdapter(this)
        recyclerview.adapter  = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)

        wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)

        wordViewModel.allWord.observe(this, Observer {
            words -> words?.let {
                words.forEach{Log.d("hua", "newWord: ${it.word}")}
                adapter.setWords(words)
            }
        })




    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.let {
                val txt = it.getStringExtra(NewWordActivity.EXTRA_REPLY)
                Log.d("hua", "txt: $txt")
                val word = Word(txt!!)
                wordViewModel.addWord(word)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG).show()
        }
    }
    companion object {
        const val newWordActivityRequestCode = 1
    }

}
