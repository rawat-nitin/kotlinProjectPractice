package edu.kcg.web3.lecture06.controller

//import org.springframework.boot.web.servlet.error.ErrorController
//import org.springframework.stereotype.Controller
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.servlet.ModelAndView
//import javax.servlet.RequestDispatcher
//import javax.servlet.http.HttpServletRequest
//
//
//@Controller
//class CustomErrorController : ErrorController {
//
//    override fun getErrorPath(): String {
//        return "/error"
//    }
//
//    @GetMapping("/error")
//    fun handleError(httpRequest: HttpServletRequest): ModelAndView {
//        val status = httpRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE) as Int
//        println(status)
//        val errorMsg = when (status) {
//            400 -> "Http Error Code: 400. Bad Request"
//            401 -> "Http Error Code: 401. Unauthorized"
//            403 -> "Http Error Code: 403. Forbidden."
//            404 -> "Http Error Code: 404. Resource not found"
//            500 -> "Http Error Code: 500. Internal Server Error"
//            else -> "Error"
//        }
//        val errorPage = ModelAndView("error")
//        errorPage.addObject("errorMessage", errorMsg)
//        return errorPage
//    }
//
//}