package edu.kcg.web3.lecture04b.model

data class Car(
    val id: Long,
    val brand: String = "",
    val color: String = "",
    val year: Int = 0,
    var odometer: Double = 0.0,
    val electric: Boolean = false
) {
    constructor() : this(-1)
}