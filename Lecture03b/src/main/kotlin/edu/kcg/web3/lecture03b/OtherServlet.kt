package edu.kcg.web3.lecture03b

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(value = ["/other"])
class OtherServlet : HttpServlet() {

    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        request.getRequestDispatcher("/index.jsp").forward(request, response)
    }

}