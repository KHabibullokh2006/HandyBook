package com.akbar.handybook.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.akbar.handybook.R
import com.akbar.handybook.adapters.BooksAdapter
import com.akbar.handybook.databinding.FragmentHomeBinding
import com.akbar.handybook.model.Book
import com.akbar.handybook.networking.APIClient
import com.akbar.handybook.networking.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    var list = listOf<Book>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        val api = APIClient.getInstance().create(APIService::class.java)

        api.getAllBooks().enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
//                Log.d("TAG", "onResponse: ${response.body()}")
                list = response.body()!!
                val adapter = BooksAdapter(list,object :BooksAdapter.OnClickBook{
                    override fun onClickRoman(book: Book) {
                        Toast.makeText(requireContext(), "Don't rush", Toast.LENGTH_SHORT).show()
                    }
                })
                binding.allbooksrecyle.adapter = adapter
                Log.d("TAG", "onResponse: ${list.size}")
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Log.d("TAG", "onResponse: $t")
            }

        })
        return binding.root
    }


}