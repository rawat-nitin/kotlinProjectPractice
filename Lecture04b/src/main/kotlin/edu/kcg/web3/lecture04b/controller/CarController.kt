package edu.kcg.web3.lecture04b.controller

import edu.kcg.web3.lecture04b.annotation.Open
import edu.kcg.web3.lecture04b.service.findCarById
import javax.inject.Inject
import javax.mvc.Models
import javax.mvc.annotation.Controller
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.QueryParam


@Path("car")
@Controller
@Open
class CarController {

    @Inject
    var models: Models? = null

    @GET
    @Path("/{id}/{brand}")
    fun getCar(
        @PathParam("id") id: Long?,
        @PathParam("brand") brand: String?
    ): String {
        println(brand)
        models?.put("car", findCarById(id ?: 1))
        return "/car.jsp"
    }

    @GET
    fun getCar2(
        @QueryParam("id") id: Long?,
        @QueryParam("brand") brand: String?
    ): String {
        return getCar(id, brand)
    }

}