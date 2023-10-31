package com.akbar.handybook.networking

import com.akbar.handybook.model.Book
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("/book-api")
    fun getAllBooks(): Call<List<Book>>

    @GET("/book-api/all-category")
    fun getAllCategories():Call<List<Book>>

    @GET("/book-api/view")
    fun getBookById(@Query("id") id: Int): Call<Book>
}