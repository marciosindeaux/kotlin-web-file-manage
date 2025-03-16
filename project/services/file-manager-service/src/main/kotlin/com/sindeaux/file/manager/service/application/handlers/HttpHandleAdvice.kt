package com.sindeaux.file.manager.service.application.handlers

import com.sindeaux.file.manager.service.application.web.responses.ErrorResponse
import com.sindeaux.file.manager.service.commons.exceptions.UploadFileException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class HttpHandleAdvice {

    @ExceptionHandler(UploadFileException::class)
    fun handleUploadFailure(uploadFileException: UploadFileException): ResponseEntity<ErrorResponse> {
        val status = HttpStatus.BAD_REQUEST
        return ResponseEntity
            .status(status.value())
            .body(
                buildDefaultErrorResponse(uploadFileException, status)
            )
    }

    fun buildDefaultErrorResponse(runtimeException: RuntimeException, status: HttpStatus) = ErrorResponse (
            runtimeException.message.orEmpty() ,
            status,
            runtimeException.cause
        )
}
