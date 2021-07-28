package edu.kcg.web3.lecture07.controller

import edu.kcg.web3.lecture07.component.PeopleDatabaseSimulator
import edu.kcg.web3.lecture07.model.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/people")
class PeopleController(@Autowired private val databaseSimulator: PeopleDatabaseSimulator) {

    @GetMapping
    fun getAll(): List<Person> {
        if (databaseSimulator.getAll().isEmpty()) {
            databaseSimulator.insert(Person("John", 35, "Java"))
        }
        return databaseSimulator.getAll()
    }

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Int?): ResponseEntity<Person> {
        val person = databaseSimulator.getById(id ?: -1)
        return if (person != null) {
            ResponseEntity<Person>(person, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping(consumes = ["application/json"])
    fun insertPerson(@RequestBody person: Person): HttpEntity<*> {
        databaseSimulator.insert(person)
        return ResponseEntity.EMPTY
    }

    @PutMapping(consumes = ["application/json"])
    fun updatePerson(@RequestBody person: Person): HttpEntity<*> {
        databaseSimulator.update(person)
        return ResponseEntity.EMPTY
    }

    @DeleteMapping(consumes = ["application/json"])
    fun deletePerson(@RequestBody person: Person): HttpEntity<*> {
        databaseSimulator.delete(person)
        return ResponseEntity.EMPTY
    }

    @DeleteMapping("/{id}")
    fun deletePersonById(@PathVariable id: Int?): HttpEntity<*> {
        databaseSimulator.getById(id ?: -1)
            ?.let { databaseSimulator.delete(it) }
        return ResponseEntity.EMPTY
    }

}
