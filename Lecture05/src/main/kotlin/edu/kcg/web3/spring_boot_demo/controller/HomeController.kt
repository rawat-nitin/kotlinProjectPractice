package edu.kcg.web3.spring_boot_demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomeController {

    @RequestMapping("/")
    fun index(model: Model): String {
        model["title"] = "Home"
        return "home"
    }

}
