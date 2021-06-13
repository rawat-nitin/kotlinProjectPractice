package edu.kcg.web3.lecture09.config

import edu.kcg.web3.lecture09.Lecture09Application
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

class ServletInitializer : SpringBootServletInitializer() {

	override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
		return application.sources(Lecture09Application::class.java)
	}

}
