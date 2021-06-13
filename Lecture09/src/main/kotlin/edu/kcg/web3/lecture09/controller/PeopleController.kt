package edu.kcg.web3.lecture09.controller

import edu.kcg.web3.lecture09.repository.PersonRepository
import edu.kcg.web3.lecture09.table.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/person")
class PeopleController(
    @Autowired val personRepository: PersonRepository,
    @Autowired val passwordEncoder: PasswordEncoder
) {

    @GetMapping("/show")
    fun showAll(model: Model, @RequestParam showDeleted: Boolean?): String {
        model["title"] = "All people"

        val people = if (showDeleted == null || showDeleted == true) {
            personRepository.findAll()
        } else {
            personRepository.findAllValid()
        }
        model["people"] = people

        if (!model.containsAttribute("message")) {
            model["message"] = ""
        }
        return "show"
    }

    @GetMapping("/insert")
    fun insertGet(model: Model): String {
        model["title"] = "Inserting person"
        model["message"] = ""
        return "insert"
    }

    @PostMapping("/insert")
    fun insertPost(
        model: Model, @RequestParam email: String?, @RequestParam password: String?, @RequestParam age: String?
    ): String {
        model["title"] = "Inserting a person"

        if (email.isNullOrBlank() || password.isNullOrBlank() || age.isNullOrBlank()) {
            model["message"] = "Some parameters were empty or blank!"
        } else {
            val person = Person().also {
                it.email = email
                it.passwordHash = passwordEncoder.encode(password)
                it.age = age.toLongOrNull() ?: 0
            }
            personRepository.save(person)
            model["message"] = "Changes saved"
        }

        return showAll(model, null)
    }

    @GetMapping("/delete/{id}")
    fun delete(model: Model, @PathVariable id: Long): String {
//        personRepository.deleteById(id)
        personRepository.markDeleted(id)
        model["title"] = "Deleted"
        return "delete"
    }

    @GetMapping("/update/{id}")
    fun updateGet(model: Model, @PathVariable id: Long): String {
        model["title"] = "Updating person"

        val person = personRepository.findById(id)
        if (person.isEmpty) {
            model["person"] = Person()
            model["message"] = "Person not found"
        } else {
            model["person"] = person.get()
            model["message"] = ""
        }
        return "update"
    }

    @PostMapping("/update")
    fun updatePost(
        model: Model,
        @RequestParam id: Long?,
        @RequestParam email: String?,
        @RequestParam password: String?,
        @RequestParam age: String?
    ): String {

        if (id == null || email.isNullOrBlank() || password.isNullOrBlank() || age.isNullOrBlank()) {
            model["message"] = "Update failed. Some properties were empty"
        } else {
            personRepository.findByIdOrNull(id)?.also {
                it.email = email
                it.passwordHash = passwordEncoder.encode(password)
                it.age = age.toLongOrNull() ?: 0
                personRepository.save(it)
                model["message"] = "Changes saved"
            } ?: let {
                model["message"] = "Person with id=$id was not found"
            }
        }
        return showAll(model, null)
    }

}