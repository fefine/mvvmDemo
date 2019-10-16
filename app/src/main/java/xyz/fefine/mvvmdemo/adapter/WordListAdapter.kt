package xyz.fefine.mvvmdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import xyz.fefine.mvvmdemo.R
import xyz.fefine.mvvmdemo.model.Word
import xyz.fefine.mvvmdemo.databinding.RecyclerviewItemBinding


class WordListAdapter internal constructor(
    // private val binding: ViewDataBinding
): RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private var words = emptyList<Word>() // Cached copy of words

    inner class WordViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        // RecyclerviewItemBinding是根据recyclerview_item自动生成的
        val itemBinding: RecyclerviewItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = words[position]
        if (holder.binding is RecyclerviewItemBinding) {
            holder.binding.txtWord = current.word
        }
    }

    internal fun setWords(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }

    override fun getItemCount() = words.size

    /*
    // no data binding
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<Word>() // Cached copy of words

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = words[position]
        holder.wordItemView.text = current.word
    }

    internal fun setWords(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }

    override fun getItemCount() = words.size
     */

}