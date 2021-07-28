package edu.kcg.web3.lecture07.model

data class Book(
    val name: String,
    val pageCount: Int,
    val author: Author,
    var id: Int = -1
)


