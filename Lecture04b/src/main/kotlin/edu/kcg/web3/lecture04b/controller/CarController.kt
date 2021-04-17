package edu.kcg.web3.lecture04b.controller

import edu.kcg.web3.lecture04b.annotation.Open
import edu.kcg.web3.lecture04b.service.findCarById
import javax.inject.Inject
import javax.mvc.Models
import javax.mvc.annotation.Controller
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam


@Path("car/{id}")
@Controller
@Open
class CarController {

    @Inject
    var models: Models? = null

    @GET
    fun getCar(@PathParam("id") id: Long?): String {
        models?.put("car", findCarById(id ?: 1))
        return "/car.jsp"
    }
}