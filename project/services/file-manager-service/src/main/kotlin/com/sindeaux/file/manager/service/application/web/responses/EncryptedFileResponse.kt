package com.sindeaux.file.manager.service.application.web.responses

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class EncryptedFileResponse (
    val fileName: String,
    val fileType: String,
    val fileSize: Long
)