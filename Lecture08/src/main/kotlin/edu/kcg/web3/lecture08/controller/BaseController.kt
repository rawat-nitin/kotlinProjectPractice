package edu.kcg.web3.lecture08.controller

import edu.kcg.web3.lecture08.model.Person
import edu.kcg.web3.lecture08.model.Quote
import org.apache.tomcat.util.codec.binary.Base64
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.*
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.client.RestTemplate


@Controller
class BaseController(@Autowired private val restTemplate: RestTemplate) {

    private val logger = LoggerFactory.getLogger(BaseController::class.java)

    @RequestMapping("/quote")
    fun quote(model: Model): String {
        val quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", Quote::class.java)
        model["title"] = quote?.type ?: "Error"
        model["quote"] = quote?.value?.quote ?: "Error"
        return "quote"
    }

    @RequestMapping("/person/{id}")
    fun getPerson(model: Model, @PathVariable id: Int): String {
        model["title"] = "Person"
        try {
            val person = restTemplate.getForObject("http://localhost:8080/people/$id", Person::class.java)
            model["person"] = person?.toString() ?: "error"
        } catch (e: Exception) {
            logger.error("Error while getting person with id=$id", e)
            model["person"] = "error"
        }
        return "person"
    }

    @RequestMapping("/person/insert/{name}/{age}/{language}")
    fun insertPerson(
        model: Model, @PathVariable name: String,
        @PathVariable age: String, @PathVariable language: String
    ): String {
        val headers = getHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val personJSON = "{\"name\":\"$name\",\"age\":$age,\"favouriteLanguage\":\"$language\"}"
        val request = HttpEntity<String>(personJSON, headers)

        val response =
            restTemplate.exchange("http://localhost:8080/people/", HttpMethod.POST, request, Void::class.java)

        model["title"] = "Person"
        if (response.statusCode == HttpStatus.OK) {
            model["person"] = personJSON
        } else {
            model["person"] = "error"
        }
        return "person"
    }

    @RequestMapping("/person/update/{id}/{name}/{age}/{language}")
    fun updatePerson(
        model: Model, @PathVariable id: String, @PathVariable name: String,
        @PathVariable age: String, @PathVariable language: String
    ): String {
        val headers = getHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val personJSON = "{\"name\":\"$name\",\"age\":$age,\"favouriteLanguage\":\"$language\",\"id\":\"$id\"}"
        val request = HttpEntity<String>(personJSON, headers)

        val response =
            restTemplate.exchange("http://localhost:8080/people/", HttpMethod.PUT, request, Void::class.java)

        model["title"] = "Person"
        if (response.statusCode == HttpStatus.OK) {
            model["person"] = personJSON
        } else {
            model["person"] = "error"
        }
        return "person"
    }

    @RequestMapping("/person/delete/{id}")
    fun deletePerson(model: Model, @PathVariable id: Int): String {
        val request = HttpEntity<Void>(getHeaders())
        val response =
            restTemplate.exchange("http://localhost:8080/people/$id", HttpMethod.DELETE, request, Void::class.java)

        model["title"] = "Person"
        if (response.statusCode == HttpStatus.OK) {
            model["person"] = "deleted"
        } else {
            model["person"] = "error"
        }
        return "person"
    }

    private fun getHeaders(): HttpHeaders {
        val credentials = String(Base64.encodeBase64("admin:password".toByteArray()))
        val headers = HttpHeaders()
        headers.add("Authorization", "Basic $credentials")
        return headers
    }

}
