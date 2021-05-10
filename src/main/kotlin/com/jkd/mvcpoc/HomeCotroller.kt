package com.jkd.mvcpoc

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class HomeController {

    private val logger = LoggerFactory.getLogger(HomeController::class.java)

    @RequestMapping("/hello")
    fun hello(@RequestParam name: String): Map<String, Any> {

        logger.debug("Name : $name")

        if(name == "ex") throw IllegalStateException("I do not like this name.")

        return mapOf(
            "greeting" to "Hello there! $name",
            "greetedAt" to LocalDateTime.now().toString()
        )
    }
}