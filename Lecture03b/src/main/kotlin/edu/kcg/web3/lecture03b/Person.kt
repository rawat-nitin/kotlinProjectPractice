package edu.kcg.web3.lecture03b

class Person {

    var name: String? = null
    var countryOfResidence: String? = null

    fun loadData(): Person {
        name = "John"
        countryOfResidence = "Taiwan"
        return this
    }

}