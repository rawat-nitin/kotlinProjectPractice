package edu.kcg.web3.lecture03b

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "helloServlet", value = ["/hello-servlet"])
class HelloServlet : HttpServlet() {

    private lateinit var message: String

    override fun init() {
        message = "Hello World!"
    }

    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        response.contentType = "text/html"
        response.characterEncoding = "utf-8"

        val s = request.queryString
        val e = request.parameterNames

        response.writer.use { writer ->
            writer.println("<html>")
            writer.println("<head>")
            writer.println("<title>The best title</title>")
            writer.println("</head>")
            writer.println("<body>")
            writer.println("<p>$message</p>")
            writer.println("<p>some useful text</p>")
            writer.println("<p>$s</p>")
            while (e.hasMoreElements()) {
                val parameter = e.nextElement().toString()
                val value = request.getParameter(parameter)
                writer.println("<p>Parameter: $parameter\nValue: $value</p>")
            }
            writer.println("</body>")
            writer.println("</html>")
        }
    }

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        doGet(request, response)
    }

    override fun destroy() {
    }
}