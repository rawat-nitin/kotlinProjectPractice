package edu.kcg.web3.lecture06.config

import edu.kcg.web3.lecture06.Lecture06Application
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

class ServletInitializer : SpringBootServletInitializer() {

	override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
		return application.sources(Lecture06Application::class.java)
	}

}
