package edu.kcg.web3.spring_boot_demo.config

import edu.kcg.web3.spring_boot_demo.SpringBootDemoApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

class ServletInitializer : SpringBootServletInitializer() {

	override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
		return application.sources(SpringBootDemoApplication::class.java)
	}

}
