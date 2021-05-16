package edu.kcg.web3.spring_boot_demo.component

import edu.kcg.web3.spring_boot_demo.model.Person
import org.springframework.stereotype.Component

@Component
class DatabaseSimulator {

    private val people = mutableListOf<Person>()
    private var idCounter = 0

    fun getById(id: Int): Person? {
        return people.find { it.id == id }
    }

    fun getAll(): List<Person> {
        return people
    }

    fun insert(person: Person): Int {
        if (person.id == -1) {
            person.id = ++idCounter
            people.add(person)
        } else {
            update(person)
        }
        return person.id
    }

    fun update(person: Person) {
        if (person.id == -1) {
            insert(person)
        } else {
            people.indexOfFirst { it.id == person.id }.let {
                people[it] = person
            }
        }
    }

    fun delete(person: Person) {
        people.remove(person)
    }

}