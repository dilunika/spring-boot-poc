package com.jkd.mvcpoc

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class ResponseExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [IllegalStateException::class])
    fun badRequestResponse(ex: RuntimeException, req: WebRequest): ResponseEntity<Any> {

        val body = ErrorResponse(
            message = ex.localizedMessage,
            dateTime = LocalDateTime.now().toString()
        )

        return handleExceptionInternal(ex, body, HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, req)
    }


}

data class ErrorResponse(val message: String, val dateTime: String)