package com.akbar.handybook.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.akbar.handybook.databinding.RomanItemBinding
import com.akbar.handybook.model.Book

class BooksAdapter(val list: List<Book>, val onClickBook: OnClickBook):
    RecyclerView.Adapter<BooksAdapter.MyHolder>(){

    class MyHolder(binding: RomanItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val book = binding.item
        val image = binding.image
        val title = binding.bookName
        val author = binding.author
        val rating = binding.rating
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            RomanItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val book = list[position]
        holder.image.load(book.image)
        holder.title.text = book.name
        holder.author.text = book.author
        holder.rating.text = book.reyting.toDouble().toString()
        holder.book.setOnClickListener {
            onClickBook.onClickRoman(book)
        }
    }
    interface OnClickBook {
        fun onClickRoman(book: Book)
    }

}
