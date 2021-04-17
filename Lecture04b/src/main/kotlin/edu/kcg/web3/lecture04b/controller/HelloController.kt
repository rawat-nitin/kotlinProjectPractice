package edu.kcg.web3.lecture04b.controller

import edu.kcg.web3.lecture04b.annotation.Open
import edu.kcg.web3.lecture04b.model.Message
import javax.inject.Inject
import javax.mvc.annotation.Controller
import javax.ws.rs.GET
import javax.ws.rs.Path


@Path("hello")
@Controller
@Open
class HelloController {

    @Inject
    var message: Message? = null

    @GET
    fun hello(): String {
        message?.text = "Today is a sunny day"
        return "/hello.jsp"
    }
}