package com.akbar.handybook.model

data class Book(
    val author: String,
    val count_page: Int,
    val description: String,
    val `file`: String,
    val id: Int,
    val image: String,
    val lang: String,
    val name: String,
    val publisher: String,
    val reyting: Double,
    val status: Int,
    val type_id: Int,
    val year: String
)