package edu.kcg.web3.lecture09.config

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder


@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    private val logger = LoggerFactory.getLogger(SecurityConfig::class.java)

    override fun configure(http: HttpSecurity) {
        logger.info("Configuring Spring security")
        http.authorizeRequests().anyRequest().permitAll()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
//        return BCryptPasswordEncoder()
//        return BCryptPasswordEncoder(13)
//        return SCryptPasswordEncoder()
        return Argon2PasswordEncoder()
        // please do not use anything else (applies in 2021, WILL change in the future)
    }

}
