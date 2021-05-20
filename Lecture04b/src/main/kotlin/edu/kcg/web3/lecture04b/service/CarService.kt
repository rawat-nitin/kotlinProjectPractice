package edu.kcg.web3.lecture04b.service

import edu.kcg.web3.lecture04b.model.Car


fun findCarById(id: Long): Car {
    return getAllCars().firstOrNull { it.id == id } ?: Car()
}

/**
 * Method for simulating database
 */
fun getAllCars(): MutableList<Car> {
    val cars = mutableListOf<Car>()
    cars.add(Car(1, "Toyota", "white", 2021, electric = true))
    cars.add(Car(2, "Ford", "red", 2019, 32_164.5))
    cars.add(Car(3, "Seat", "blue", 2021))
    cars.add(Car(4, "Volkswagen", "white", 2010, 157_324.0))
    cars.add(Car(5, "Mitsubishi", "red", 2017, 36_713.4))
    cars.add(Car(6, "Honda", "blue", 2018, 36_713.4))
    cars.add(Car(7, "Ford", "red", 2015, 82_111.5))
    cars.add(Car(8, "Volkswagen", "red", 2001, 382_142.1))
    cars.add(Car(9, "Volkswagen", "white", 2017, 14680.3, true))
    cars.add(Car(10, "Suzuki", "red", 2012, 132_999.4))
    return cars
}
