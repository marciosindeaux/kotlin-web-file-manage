package com.sindeaux.file.manager.service.application.web.responses

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.http.HttpStatus

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
class ErrorResponse(
    val message: String,
    val status: HttpStatus
) {
    var subCauseMessages: MutableList<String> = mutableListOf();

    constructor(message: String, status: HttpStatus, cause: Throwable?) : this(message, status) {
        var mainSubCause  = cause
        do {
            if(mainSubCause != null) {
                if(!mainSubCause.message.isNullOrEmpty()) {
                    subCauseMessages.add(mainSubCause.message.orEmpty())
                }
                mainSubCause = mainSubCause.cause;
            }
        } while (mainSubCause?.cause != null);
    }
}