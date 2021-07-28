package edu.kcg.web3.lecture08.controller

import edu.kcg.web3.lecture08.model.Movie
import edu.kcg.web3.lecture08.model.MovieSearchResult
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate


@Controller
class MovieController(@Autowired private val restTemplate: RestTemplate) {

    @GetMapping("/movies")
    fun getMovies(model: Model): String {
        model["title"] = "Search movies"
        model["movie"] = emptyList<Movie>()
        return "movie"
    }

    @PostMapping("/movies")
    fun searchMovies(model: Model, @RequestParam name: String?): String {
        val url = "https://www.omdbapi.com/?apikey=da03bdf7&s=$name&r=json"
        val movieSearchResult = restTemplate.getForObject(url, MovieSearchResult::class.java)

        model["title"] = "Search movies"
        model["movie"] = movieSearchResult?.Search ?: emptyList<Movie>()
        return "movie"
    }

}
