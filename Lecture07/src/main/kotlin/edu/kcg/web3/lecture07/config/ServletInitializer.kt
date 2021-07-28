package edu.kcg.web3.lecture07.config

import edu.kcg.web3.lecture07.Lecture07Application
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

class ServletInitializer : SpringBootServletInitializer() {

	override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
		return application.sources(Lecture07Application::class.java)
	}

}
